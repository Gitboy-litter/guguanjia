let vm = new Vue({
    el: '.main-content',
    data: {
        app: {}
    },
    methods: {
        update: function () {
            axios({
                url: "manager/app/updateAppVersionById",
                method: "post",
                data: this.app
            }).then(response => {
                let index = parent.layer.getFrameIndex(window.name);
                if (response.data.success) {
                    parent.layer.close(index);
                    parent.layer.msg(response.data.msg, {icon: 1});
                } else {
                    layer.msg(response.data.msg, {icon: 1});
                }
            }).catch(error => {
                alert(error.data.message)
            })
        },
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