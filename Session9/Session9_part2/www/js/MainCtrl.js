app.controller('MainCtrl', function($scope, $http, $timeout) {

  var url = "http://www.w3schools.com/angular/customers_mysql.php";
  $scope.customers = [{"Name":"sarah", "City":"khi", "Country":"pk"}];

  var callback = function(response) {
    console.log("inside callback");

    $scope.customers = response.data.records;

    // $timeout(function() {
    //   $scope.$apply();
    //   console.log("dsfds")
    //   console.log($scope.customers)
    // })
  }


  $http.get(url).then(callback);

})
