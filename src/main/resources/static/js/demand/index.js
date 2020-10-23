let vue = new Vue({
    el: '.main-content',
    data: {
        pageinfo: {},
        demand: {},
        active:true
    },
    methods: {
        getDemandAll: function (pageNo = 1, pageSize = 3) {
            axios({
                url: 'manager/demand/getDemandAll',
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
        detail:function (demand) {
            layer.obj = demand;
            layer.open({
                type: 2,
                title: '详细情况',
                area: ['80%', '80%'],
                content: 'manager/demand/toDetail',
                end:  ()=> {
                }
            })
        }
    },
    clear: function () {
        this.demand = {};//清空属性数据
    },
    created: function () {
        this.getDemandAll();
    }
});
