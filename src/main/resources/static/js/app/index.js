let vm = new Vue({
    el: '.main-content',
    data: {
        // apps: {},
        pageinfo: {},
        app: {
            platform:"0",
            forceUpdate:"0"
        },
        active:true
    },
    methods: {
        getAppVersionAll: function (pageNo = 1, pageSize = 3) {
            axios({
                url: 'manager/app/getAppVersionAll',
                method: "get",
                params: {pageNo: pageNo, pageSize: pageSize}
            }).then(
                response => {
                    this.pageinfo = response.data.obj
                }
            ).catch(error => {
                console.log(error.message);
            })
        },
        layertoupdate: function (app) {
            layer.obj = app;
            layer.open({
                type: 2,
                title: '更新app',
                area: ['80%', '80%'],
                content: 'manager/app/toUpdate',
                end:  ()=> {
                        this.getAppVersionAll();
                }
            })
        },
        deleteById: function (app) {
            layer.confirm('确定要删除?', {
                btn: ['确定', '不要']
            },  ()=> {
                app.delFlag="1";
                axios({
                    url: 'manager/app/updateAppVersionById',
                    method: "post",
                    data: app,
                    headers: {'Content-Type': 'application/json;charset=utf-8'}
                }).then(
                    response => {
                        layer.msg(response.data.msg, {icon: 1})
                        this.getAppVersionAll();
                    }
                ).catch(error => {
                    console.log(error.message);
                });
            },  ()=> {
            });
        },
        insertPerson:function () {
            axios({
                url: 'manager/app/insertPerson',
                method: "post",
                data: this.app,
                headers: {'Content-Type': 'application/json;charset=utf-8'}
            }).then(
                response => {
                    if (response.data.success){
                        this.app={}
                        this.app.platform="0"
                        this.app.forceUpdate="0"
                        this.getAppVersionAll();
                        this.active=!this.active
                    }
                        layer.msg(response.data.msg,{icon:1})
                }
            ).catch(error => {
                console.log(error.message);
            });
        },
        detail:function (app) {
            layer.obj = app;
            layer.open({
                type: 2,
                title: '详细情况',
                area: ['80%', '80%'],
                content: 'manager/app/toDetail',
                end:  ()=> {
                }
            })
        }
    },
    clear: function () {
        this.app = {};//清空属性数据
    },
    created: function () {
        this.getAppVersionAll();
    }
});
