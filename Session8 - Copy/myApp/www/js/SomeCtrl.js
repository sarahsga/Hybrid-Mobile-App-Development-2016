app.controller('MainCtrl', function($scope) {

    var price_per_apple = 5;
  // $scope.price = 0

  $scope.someObj = {
    "count": 0,
    "price":0
  }

  $scope.btn_clicked = function() {
    console.log("count = " + $scope.someObj.count)
    $scope.someObj.price = $scope.someObj.count * price_per_apple;
  }

});
