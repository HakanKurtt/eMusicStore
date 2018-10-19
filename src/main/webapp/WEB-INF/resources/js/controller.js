new Vue({
    el: "#app",
    data: {
        results:[]
    },
    methods: {
        refreshCart: function(cartId) {
            this.$http.get('/eMusicStore/rest/cart/'+cartId, function(data, status, request){
                if(status == 200){
                    this.results = data;
                }
            })
        },
        clearCart: function(cartId) {
            this.$http.delete('/eMusicStore/rest/cart/'+cartId);
        },
        initCart: function(cartId) {
            this.refreshCart(cartId);
        },
        addToCart: function(producId){
            $http.put('/eMusicStore/rest/cart/add/'+producId, function(data, status, request){
                this.refreshCart($http.get('/eMusicStore/rest/cart/cartId'));
                alert('Product successfully added to the cart!');
            })
        },
        removeFromCart: function(productId){
            $http.put('/eMusicStore/rest/cart/remove/'+productId, function(data, status, request){
                this.refreshCart($http.get('/eMusicStore/rest/cart/cartId'))
            })
        }
    },
    beforeMount(){
        this.initCart()
    }

})