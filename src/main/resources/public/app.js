app = angular.module("SignIn",["ngRoute"]);

app.run(function($rootScope,$http){

    $rootScope.menuRoutes=[
        {label:"Register",link:"#!register",cls:"", txtColor:"text-dark" },
        {label:"Login",link:"#!login",cls:"mg-green rounded",txtColor:"text-white"},
        {label:"Account",link:"#!account",cls:"", txtColor:"text-dark"},
        {label:"Pending Approvals",link:"#!approvals",cls:"", txtColor:"text-dark"},
        {label:"Cohorts",link:"#!cohorts",cls:"", txtColor:"text-dark"},
        {label:"Users",link:"#!users",cls:"", txtColor:"text-dark"},
        {label:"Attendance",link:"#!attendance",cls:"", txtColor:"text-dark"},        
        {label:"Appeals",link:"#!appeals",cls:"", txtColor:"text-dark"}
    ];

    $rootScope.users=[
        {id:0,name:"John Doe",email:"mail@mail.com",cohort:"Android",role:"normal",regdate:"2019-11-01"},
        {id:1,name:"Ann G",email:"mail@mail.com",cohort:"Data Science",role:"admin",regdate:"2019-12-01"},
        {id:2,name:"Alex W",email:"mail@mail.com",cohort:"Android",role:"TM",regdate:"2019-11-01"},
        {id:3,name:"Moses W",email:"mail@mail.com",cohort:"Data Science",role:"normal",regdate:"2019-12-01"},
        {id:4,name:"Esther M",email:"mail@mail.com",cohort:"Android",role:"TM",regdate:"2019-11-01"},
        {id:5,name:"Ann Doe",email:"mail@mail.com",cohort:"Data Science",role:"normal",regdate:"2019-12-01"},
        {id:6,name:"John Doe",email:"mail@mail.com",cohort:"Android",role:"Admin",regdate:"2019-11-01"},
        {id:7,name:"Ann Doe",email:"mail@mail.com",cohort:"Data Science",role:"normal",regdate:"2019-12-01"}
    ];

    $rootScope.cohorts = [
        {id:1,name:"MC-22",module:"Java",startdate:"2019-11-01",enddate:"2020-02-14"},
        {id:2,name:"MC-22",module:"Python",startdate:"2019-11-01",enddate:"2020-02-14"},
        {id:3,name:"MC-22",module:"Android",startdate:"2019-11-01",enddate:"2020-02-14"},
        {id:4,name:"MC-01",module:"Data Science",startdate:"2019-12-01",enddate:"2020-03-30"}
    ];

    $rootScope.attendance=[
        {id:1,year:2019,month:"September",day:23,cohort:"MC-22 Android",present:12,absent:0},
        {id:1,year:2019,month:"October",day:24,cohort:"MC-22 Java",present:12,absent:0},
        {id:1,year:2019,month:"November",day:25,cohort:"MC-22 Python",present:50,absent:0},
        {id:1,year:2019,month:"December",day:2,cohort:"MC-01 Date Science",present:40,absent:0},
    ];

    $rootScope.appeals=[

        {id:1,appealdate:"2019-11-02",status:"closed",user:1,message:"Was ill and not able to attend.",responses:[
            {id:1,resdate:"2019-11-03",type:"response",message:"Please provide a doctor's letter."},
            {id:2,resdate:"2019-11-04",type:"repeal",message:"Sent via slack."},
            {id:3,resdate:"2019-11-05",type:"response",message:"Ok, will consider."},
        ]},

        {id:2,appealdate:"2019-11-02",status:"closed",user:1,message:"Was ill and not able to attend.",responses:[
            {id:1,resdate:"2019-11-03",type:"response",message:"Please provide a doctor's letter."},
            {id:2,resdate:"2019-11-04",type:"repeal",message:"Sent via slack."},
            {id:3,resdate:"2019-11-05",type:"response",message:"Ok, will consider."},
        ]},

        {id:3,appealdate:"2019-11-02",status:"closed",user:1,message:"Was ill and not able to attend.",responses:[
            {id:1,resdate:"2019-11-03",type:"response",message:"Please provide a doctor's letter."},
            {id:2,resdate:"2019-11-04",type:"repeal",message:"Sent via slack."},
            {id:3,resdate:"2019-11-05",type:"response",message:"Ok, will consider."},
        ]},

        {id:4,appealdate:"2019-12-01",status:"ongoing",user:2,message:"Laptop broke down.",responses:[
            {id:1,resdate:"2019-12-02",type:"response",message:"Was it repaired?"},
            {id:2,resdate:"2019-12-03",type:"repeal",message:"Yes."},
            {id:3,resdate:"2019-12-04",type:"response",message:"Share the fee receipt."},
        ]},

        {id:5,appealdate:"2019-12-01",status:"ongoing",user:2,message:"Laptop broke down.",responses:[
            {id:1,resdate:"2019-12-02",type:"response",message:"Was it repaired?"},
            {id:2,resdate:"2019-12-03",type:"repeal",message:"Yes."},
            {id:3,resdate:"2019-12-04",type:"response",message:"Share the fee receipt."},
        ]},

        {id:6,appealdate:"2019-12-04",status:"new",user:2,message:"Overslept.",responses:[]},
        {id:7,appealdate:"2019-12-04",status:"new",user:2,message:"Overslept.",responses:[]},
        {id:8,appealdate:"2019-12-04",status:"new",user:2,message:"Overslept.",responses:[]},
        {id:9,appealdate:"2019-12-04",status:"new",user:2,message:"Overslept.",responses:[]}

    ];

    $rootScope.threads=[];
    $rootScope.replies=[];

    $rootScope.appeals.forEach(element => { 
        $rootScope.threads.push(null); 
        $rootScope.replies.push(""); 
    });

    $rootScope.viewThread = function(t_index){
        console.log(t_index);
        $rootScope.threads.forEach((item,index)=>{
            $rootScope.threads[index] = index == t_index ? true: null;
        });
    };   

    $rootScope.hideThread = function(t_index){$rootScope.threads[t_index]=null;}

    $rootScope.closeAppeal = function(t_index){
        $rootScope.appeals[t_index].status="closed";
    }

    $rootScope.appealmsg=[];
    $rootScope.appealmsg.push("");
    $rootScope.appeal = function(){
        //console.log($rootScope.appealmsg[0]);
        $rootScope.appeals.push(
            { id:$rootScope.appeals.length+1,
             appealdate: new Date(),
             status:"new",
             user:$rootScope.appeals.length+1,
             message:$rootScope.appealmsg[0],
             responses:[]
            }
        ); //end new appeal push

        $rootScope.appealmsg[0]="";

    }

    $rootScope.reply =  function(t_index){
        console.log(t_index+" : "+$rootScope.replies[t_index]+" : "+$rootScope.appeals[t_index].responses.length);
        
        if ($rootScope.replies[t_index].length > 0) //dont push empty replies
        
        $rootScope.appeals[t_index].responses.push(

            $rootScope.appeals[t_index].responses.length>0?
            {id:$rootScope.appeals[t_index].responses.length+1,
             resdate:new Date(),
             type:$rootScope
                  .appeals[t_index]
                  .responses[$rootScope.appeals[t_index].responses.length-1]
                  .type==="repeal"? "response":"repeal",
             message:$rootScope.replies[t_index]
            }
            :
            {id:$rootScope.appeals[t_index].responses.length+1,
             resdate:new Date(),
              type:"response",
              message:$rootScope.replies[t_index]
            }

        ); //close push brace

        //move appeal from new to ongoing if its the first reply
        if($rootScope.appeals[t_index].responses.length==1)
        $rootScope.appeals[t_index].status="ongoing";

        $rootScope.replies[t_index]="" //clear reply input box
    }

    $rootScope.navigate=function(link){
       
        $rootScope.menuRoutes.map(
            route=>  {

                 switch(route.label){

                     case link.label:
                         route.cls = "mg-green  rounded"
                         route.txtColor ="text-white"
                      break;

                      default:
                          route.cls = ""
                          route.txtColor ="text-dark"
                 }

        });
    }

    $rootScope.approve=function(id,reply_action){
    }

});

app.config(function($routeProvider){

    $routeProvider
    .when("/register",{ templateUrl:"register.html", controller:"register" })
    .when("/login",{ templateUrl:"login.html", controller:"login"  })
    .when("/account",{ templateUrl:"account.html", controller:"account"  })
    .when("/approvals",{ templateUrl:"approvals.html", controller:"approvals"  })
    .when("/cohorts",{ templateUrl:"cohorts.html", controller:"cohorts"  })
    .when("/users",{ templateUrl:"users.html", controller:"users"  })
    .when("/attendance",{ templateUrl:"attendance.html", controller:"attendance"  })
    .when("/appeals",{ templateUrl:"appeals.html", controller:"appeals"  })
    .when("/appeals/ongoing",{ templateUrl:"appeals_ongoing.html", controller:"appeals"  })
    .when("/appeals/closed",{ templateUrl:"appeals_closed.html", controller:"appeals"  })
    .otherwise({redirectTo:"/login"});

});

app.controller("register",function($scope,$http,$timeout){    

    $scope.title="Register";    
    $scope.roles=[{id:1,name:"normal"},{id:2,name:"admin"},{id:3,name:"TM"}];

    $scope.name="";
    $scope.email="";
    $scope.password="";
    $scope.password_retype="";
    $scope.cohort=null;
    $scope.role="";

    $scope.register = function(){
        $scope.name="";
        $scope.email="";
        $scope.password="";
        $scope.password_retype="";
        $scope.cohort=null;
        $scope.role="";
    }
});

app.controller("login",function($scope,$http,$timeout){
    $scope.title="Login";
    $scope.email="";
    $scope.password="";
    
    $scope.login = function(){
        $scope.email="";
        $scope.password="";
    }
});

app.controller("account",function($scope,$http,$timeout){
    $scope.title="User Account";
});

app.controller("approvals",function($scope,$http,$timeout){
    $scope.title="Pending Approvals";
});

app.controller("cohorts",function($scope,$http,$timeout){
    $scope.title="School Cohorts";
});

app.controller("users",function($scope,$http,$timeout){
    $scope.title="Users";
});

app.controller("attendance",function($scope,$http,$timeout){
    $scope.title="Attendance";
});

app.controller("appeals",function($scope,$http,$timeout){
    $scope.title="Appeals";
});
