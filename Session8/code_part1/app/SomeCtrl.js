app.controller('MainCtrl', function($scope) {

  var price_per_apple = 5;
  $scope.price = 0

  $scope.btn_clicked = function() {
    $scope.price = $scope.count * price_per_apple;
  }

})
