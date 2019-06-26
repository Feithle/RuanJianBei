/**
 * 
 * 
 */
function spiter(){


	$.ajax({
        type : "POST",
        dataType : "text",
        url : 'SpiterServlet',
        data : {
        		"url" : $("#input-22").val(),//获得用户输入的url
        	},
        	beforeSend:function() { 
      		  $("#loading").show();
      		  $("body , html").animate({scrollTop:0},300);
      		  /****************************************************************************/

      		  var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

      		  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

      		  var RotatingCircle = function () {
      		    function RotatingCircle(canvas, opts) {
      		      _classCallCheck(this, RotatingCircle);

      		      this.ctx = canvas.getContext('2d');
      		      this.size = Math.min(canvas.clientWidth, canvas.clientHeight);
      		      this.radius = opts.radius;
      		      this.lineWidth = opts.lineWidth;
      		      this.strokeStyle = opts.strokeStyle;
      		      this.degreeStart = opts.degreeStart;
      		      this.degreeEnd = opts.degreeEnd;
      		      this.stepStart = opts.stepStart;
      		      this.stepEnd = opts.stepEnd;
      		    }

      		    _createClass(RotatingCircle, [{
      		      key: 'render',
      		      value: function render() {
      		        this.degreeStart = this.degreeStart + this.stepStart;
      		        this.degreeEnd = this.degreeEnd + this.stepEnd;
      		        if (this.degreeStart - 360 > this.degreeEnd) {
      		          this.degreeStart -= 720;
      		        }

      		        this.ctx.clearRect(0, 0, this.size, this.size);
      		        this.ctx.lineWidth = this.lineWidth;
      		        this.ctx.beginPath();
      		        this.ctx.strokeStyle = this.strokeStyle;
      		        this.ctx.arc(this.size / 2, this.size / 2, this.radius - this.lineWidth / 2, (this.degreeStart < this.degreeEnd ? this.degreeStart : this.degreeEnd) * Math.PI / 180, (this.degreeStart < this.degreeEnd ? this.degreeEnd : this.degreeStart) * Math.PI / 180, false);
      		        this.ctx.stroke();
      		      }
      		    }]);

      		    return RotatingCircle;
      		  }();

      		  var circles = [new RotatingCircle(document.querySelector('.js-rotate-01'), {
      		    radius: 24,
      		    lineWidth: 12,
      		    strokeStyle: '#587fa5',
      		    degreeStart: -90,
      		    degreeEnd: 270,
      		    stepStart: 4,
      		    stepEnd: 3
      		  }), new RotatingCircle(document.querySelector('.js-rotate-02'), {
      		    radius: 40,
      		    lineWidth: 8,
      		    strokeStyle: '#7fa4d3',
      		    degreeStart: -90,
      		    degreeEnd: 270,
      		    stepStart: 6,
      		    stepEnd: 3
      		  }), new RotatingCircle(document.querySelector('.js-rotate-03'), {
      		    radius: 50,
      		    lineWidth: 3,
      		    strokeStyle: '#aacaf1',
      		    degreeStart: -90,
      		    degreeEnd: 270,
      		    stepStart: 12,
      		    stepEnd: 9
      		  }), new RotatingCircle(document.querySelector('.js-rotate-04'), {
      		    radius: 28,
      		    lineWidth: 18,
      		    strokeStyle: '#a5586c',
      		    degreeStart: -90,
      		    degreeEnd: 270,
      		    stepStart: 2,
      		    stepEnd: 1
      		  }), new RotatingCircle(document.querySelector('.js-rotate-05'), {
      		    radius: 40,
      		    lineWidth: 8,
      		    strokeStyle: '#d37f87',
      		    degreeStart: -90,
      		    degreeEnd: 180,
      		    stepStart: 8,
      		    stepEnd: 2
      		  }), new RotatingCircle(document.querySelector('.js-rotate-06'), {
      		    radius: 50,
      		    lineWidth: 3,
      		    strokeStyle: '#f1aab1',
      		    degreeStart: -90,
      		    degreeEnd: 270,
      		    stepStart: 14,
      		    stepEnd: 2
      		  })];
      		  var renderLoop = function renderLoop() {
      		    circles.map(function (circle) {
      		      circle.render();
      		    });
      		    requestAnimationFrame(function () {
      		      renderLoop();
      		    });
      		  };
      		  renderLoop();
      		  }, 
      		  /****************************************************************************/
      		complete:function(data) { 
      			 $("#loading").hide();
      		  },
        success : function(r) {//接收嵌入结果
        		alert(r.toString().replace('"', "").replace('"', ""));  
			}  
     }
	);


}
function Analyze(){
	$.ajax({
        type : "POST",
        dataType : "json",
        url : 'CompareServlet',
        data : {
        		"key" : $("#input-7").val(),//获得用户输入的密钥
        	},
        	beforeSend:function() { 
      		  $("#loading").show();
      		  $("body , html").animate({scrollTop:0},300);
      		  /****************************************************************************/

      		  var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

      		  function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

      		  var RotatingCircle = function () {
      		    function RotatingCircle(canvas, opts) {
      		      _classCallCheck(this, RotatingCircle);

      		      this.ctx = canvas.getContext('2d');
      		      this.size = Math.min(canvas.clientWidth, canvas.clientHeight);
      		      this.radius = opts.radius;
      		      this.lineWidth = opts.lineWidth;
      		      this.strokeStyle = opts.strokeStyle;
      		      this.degreeStart = opts.degreeStart;
      		      this.degreeEnd = opts.degreeEnd;
      		      this.stepStart = opts.stepStart;
      		      this.stepEnd = opts.stepEnd;
      		    }

      		    _createClass(RotatingCircle, [{
      		      key: 'render',
      		      value: function render() {
      		        this.degreeStart = this.degreeStart + this.stepStart;
      		        this.degreeEnd = this.degreeEnd + this.stepEnd;
      		        if (this.degreeStart - 360 > this.degreeEnd) {
      		          this.degreeStart -= 720;
      		        }

      		        this.ctx.clearRect(0, 0, this.size, this.size);
      		        this.ctx.lineWidth = this.lineWidth;
      		        this.ctx.beginPath();
      		        this.ctx.strokeStyle = this.strokeStyle;
      		        this.ctx.arc(this.size / 2, this.size / 2, this.radius - this.lineWidth / 2, (this.degreeStart < this.degreeEnd ? this.degreeStart : this.degreeEnd) * Math.PI / 180, (this.degreeStart < this.degreeEnd ? this.degreeEnd : this.degreeStart) * Math.PI / 180, false);
      		        this.ctx.stroke();
      		      }
      		    }]);

      		    return RotatingCircle;
      		  }();

      		  var circles = [new RotatingCircle(document.querySelector('.js-rotate-01'), {
      		    radius: 24,
      		    lineWidth: 12,
      		    strokeStyle: '#587fa5',
      		    degreeStart: -90,
      		    degreeEnd: 270,
      		    stepStart: 4,
      		    stepEnd: 3
      		  }), new RotatingCircle(document.querySelector('.js-rotate-02'), {
      		    radius: 40,
      		    lineWidth: 8,
      		    strokeStyle: '#7fa4d3',
      		    degreeStart: -90,
      		    degreeEnd: 270,
      		    stepStart: 6,
      		    stepEnd: 3
      		  }), new RotatingCircle(document.querySelector('.js-rotate-03'), {
      		    radius: 50,
      		    lineWidth: 3,
      		    strokeStyle: '#aacaf1',
      		    degreeStart: -90,
      		    degreeEnd: 270,
      		    stepStart: 12,
      		    stepEnd: 9
      		  }), new RotatingCircle(document.querySelector('.js-rotate-04'), {
      		    radius: 28,
      		    lineWidth: 18,
      		    strokeStyle: '#a5586c',
      		    degreeStart: -90,
      		    degreeEnd: 270,
      		    stepStart: 2,
      		    stepEnd: 1
      		  }), new RotatingCircle(document.querySelector('.js-rotate-05'), {
      		    radius: 40,
      		    lineWidth: 8,
      		    strokeStyle: '#d37f87',
      		    degreeStart: -90,
      		    degreeEnd: 180,
      		    stepStart: 8,
      		    stepEnd: 2
      		  }), new RotatingCircle(document.querySelector('.js-rotate-06'), {
      		    radius: 50,
      		    lineWidth: 3,
      		    strokeStyle: '#f1aab1',
      		    degreeStart: -90,
      		    degreeEnd: 270,
      		    stepStart: 14,
      		    stepEnd: 2
      		  })];
      		  var renderLoop = function renderLoop() {
      		    circles.map(function (circle) {
      		      circle.render();
      		    });
      		    requestAnimationFrame(function () {
      		      renderLoop();
      		    });
      		  };
      		  renderLoop();
      		  }, 
      		  /****************************************************************************/
      		complete:function(data) { 
      			 $("#loading").hide();
      			 var h = $(document).height()-$(window).height();
 	            $(document).scrollTop(h);
      		  },
        success : function(r) {//接收嵌入结果
        		$("#input-28").val(r["Mac"])
        		$("#input-29").val(r["Watermarkcontent"])
        		$("#input-30").val(r["Result"])
        		$("#input-28").focus();
        		$("#input-29").focus();
        		$("#input-30").focus();
        }
     }
	);

	
}