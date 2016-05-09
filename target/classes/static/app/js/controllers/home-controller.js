
app.controller('AppController', ['$scope', 'Upload', '$timeout', 'websiteFactory', 'ModalService',
                                 function($scope, Upload, $timeout, websiteFactory, ModalService) {
	$scope.limit = '5';
//	ModalService.showModal({
//        templateUrl: 'modal.html',
//        controller: "ModalController",
//        inputs: {
//            modalMessage: "Please upload your csv file..."
//          }
//    });
	$scope.uploadCsv = function(file) {
		console.log(Upload);
	    file.upload = Upload.upload({
	      url: '/upload',
	      file: file
	    });
	    file.upload.then(function (response) {
		      $timeout(function () {
		        file.result = response.data;
		      });
		    }, function (response) {
		    	
		      if (response.status > 0)
		        $scope.errorMsg = response.status + ': ' + response.data;
		    }, function (evt) {
		      // Math.min is to fix IE which reports 200% sometimes
		    	var progress = Math.min(100, parseInt(100.0 * evt.loaded / evt.total));
			    file.progress = progress;
	    });
	};
	$scope.websites = [];
	var today = new Date()
	var todayStr = today.getFullYear() + '-' + 
		("0" + (today.getMonth() + 1)).slice(-2) + '-' + 
		("0" + today.getDate()).slice(-2);
	$scope.fromDate = todayStr;
	$scope.toDate = todayStr;
	$scope.changed = function() {
		$scope.websites = [];
		websiteFactory.getTop(this.fromDate, this.toDate, this.limit)
			.then(function mySucces(response) {
		        if(response.data) {
		        	angular.forEach(response.data, function(value, key) {
		        		var ws = new website(key, value);
		        		$scope.websites.push(ws);
		        	})
		        }
		    }, function myError(response) {
		    	console.log(response);
		    });
	}
 }]);

//app.controller('ModalController', function($scope, close, modalMessage) {
//	$scope.modalMessage = modalMessage;
//	 $scope.close = function(result) {
//	 	close(result, 500); 
//	 };
//
//});
