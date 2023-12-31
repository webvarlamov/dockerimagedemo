function uuidv4() {
    return "10000000-1000-4000-8000-100000000000".replace(/[018]/g, c =>
        (c ^ crypto.getRandomValues(new Uint8Array(1))[0] & 15 >> c / 4).toString(16)
    );
}

const app = Vue.createApp({
    template: `
        <div id="message-list-header">
            <h3>Школа программистов</h3>
            <img src="https://i.hh.ru/logos/svg/hh.ru__min_.svg" alt="">
        </div>
        <div id="message-list-wrapper">
            <div class="message-list">
                <div class="message-list-item" v-for="message in messages" :key="message.messageId">
                    <div class="message-list-item-meta">
                        <span class="message-list-item-username" v-bind:style="{'color': message.serviceUuid}">
                            {{message.userName}}
                        </span>
                        <span class="message-list-item-service-uuid">
                            {{message.serviceUuid}}
                        </span>
                    </div>
                    <div class="message-list-item-payload">
                        {{message.payload}}
                    </div>
                    <div class="message-list-item-date">
                        {{message.dateTime}}
                    </div>
                </div>
            </div>
        </div>
        <div class="message-input-wrapper">
            <input type="text" v-model="message" v-on:keyup.enter="onEnter">
            <button @click="saveMessage()"></button>
        </div>
    `,
    data() {
        return {
            messages: [],
            message: '',
            userName: '',
            sessionUuid: '',
        }
    },
    methods: {
        isMessageListScrollOnDown() {
            const messageListWrapper = document.getElementById("message-list-wrapper");
            return messageListWrapper.scrollTop === 0;
        },
        scrollMessageListToBottom() {
            const messageListWrapper = document.getElementById("message-list-wrapper");
            messageListWrapper.scrollTo({
                top: 0,
                behavior: 'smooth'
            })
        },
        clearMessages() {
            this.messages = [];
        },
        loadMessages() {
            fetch("/message/getMessages")
                .then(response => response.json())
                .then(json => {
                     const messages = json.map(message => {
                        const dateTime = message.dateTime.split("T");
                        const date = dateTime[0].split("-").reverse().join(".");
                        const time = dateTime[1].split(".")[0];
                        return {...message, dateTime: date + " " + time}
                    });

                    if(this.isMessageListScrollOnDown()) {
                        this.$nextTick(() => {
                            this.scrollMessageListToBottom();
                        })
                    }

                    this.messages = messages;
                })
        },
        loop() {
            setInterval(() => {
                this.loadMessages()
            }, 1000)
        },
        onEnter: function() {
            this.saveMessage()
        },
        saveMessage() {
            if (this.message && this.message !== '') {
                fetch("/message/saveMessage", {
                    method: "POST",
                    body: JSON.stringify({
                        sessionUuid: this.sessionUuid,
                        userName: this.userName,
                        payload: this.message,
                    }),
                    headers: {
                        "Content-Type": "application/json"
                    }
                }).then(response => response.json())
                    .then(json => {
                        this.message = ''
                    })
            }

            if(this.isMessageListScrollOnDown()) {
                this.scrollMessageListToBottom();
            }
        }
    },
    mounted() {
        this.sessionUuid = localStorage.getItem("sessionUuid") || uuidv4();
        localStorage.setItem("sessionUuid", this.sessionUuid);

        this.userName = localStorage.getItem("userName") || prompt('Как тебя зовут?', "Сомнительное имя");
        localStorage.setItem("userName", this.userName);

        this.loop();
    }
})

const vm = app.mount('#app')
