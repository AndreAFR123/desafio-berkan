angular.module('myApp',[]).controller('ctrlMain', function($scope, $http) {
    var url = 'rest/valores/';

    $scope.valores = [];

	$scope.getValores = function(dependentes, salario) {
		$http({
			method : 'GET',
			url : url + dependentes + '/' + salario
		}).then(function(response) {
			console.log('Sucesso metodo getValores.');
            $scope.valores = response.data;
		}, function(response) {
			console.log('Erro metodo getValores.');
            console.log(response.data);
		});
	};
});