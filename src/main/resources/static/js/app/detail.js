let vm = new Vue({
    el: '#main-container',
    data: {
        app: {}
    },
    methods: {
        close: function () {
            let index = parent.layer.getFrameIndex(window.name);
            parent.layer.flag = true;
            parent.layer.close(index);
        }
    },
    created: function () {
        this.app = parent.layer.obj;
        console.log(this.app);
    }
})