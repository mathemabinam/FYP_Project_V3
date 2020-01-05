var config = {
    apiKey: "AIzaSyAhf3_G2ViF_NFdbhE5lQwAHa2OLip8K44",
    authDomain: "contactform-6c1c7.firebaseapp.com",
    databaseURL: "https://contactform-6c1c7.firebaseio.com",
    projectId: "contactform-6c1c7",
    storageBucket: "contactform-6c1c7.appspot.com",
    messagingSenderId: "434895775776",
    appId: "1:434895775776:web:3b8eb2cb1f5f93e6e2b445",
    measurementId: "G-23CK5X2G4J"
  };
  firebase.initializeApp(config);
   
  // // Initialize Firebase (ADD YOUR OWN DATA)
  // var config = {
  //   apiKey: "xxxxx",
  //   authDomain: "xxxxx",
  //   databaseURL: "xxxxx",
  //   projectId: "xxxxx",
  //   storageBucket: "xxxxx",
  //   messagingSenderId: "xxxxx"
  // };
  // firebase.initializeApp(config);
  
  // Reference messages collection
  var messagesRef = firebase.database().ref('messages');
  
  // Listen for form submit
  document.getElementById('contactForm').addEventListener('submit', submitForm);
  
  // Submit form
  function submitForm(e){
    e.preventDefault();
  
    // Get values
    var code = getInputVal('code');
    var desc = getInputVal('desc');

    
  
    // Save message
    saveMessage(code, desc);
  
    // Show alert
    document.querySelector('.alert').style.display = 'block';
  
    // Hide alert after 3 seconds
    setTimeout(function(){
      document.querySelector('.alert').style.display = 'none';
    },3000);
  
    // Clear form
    document.getElementById('contactForm').reset();
  }
  
  // Function to get get form values
  function getInputVal(id){
    return document.getElementById(id).value;
  }
  
  // Save message to firebase
  function saveMessage(code, desc){
    var newMessageRef = messagesRef.push();
    newMessageRef.set({
      code:code,
      desc:desc,
    
      });
  }




// 		// Your web app's Firebase configuration
// 		var firebaseConfig = {
// 		  apiKey: "AIzaSyCKSoY6wJEKdLM24FSYwRSWMk8_p7T9kwU",
// 		  authDomain: "admin-8f87f.firebaseapp.com",
// 		  databaseURL: "https://admin-8f87f.firebaseio.com",
// 		  projectId: "admin-8f87f",
// 		  storageBucket: "admin-8f87f.appspot.com",
// 		  messagingSenderId: "121175301249",
// 		  appId: "1:121175301249:web:f743d7390248166b554180",
// 		  measurementId: "G-YMPYC57FPW"
// 		};
// 		// Initialize Firebase
// 		firebase.initializeApp(firebaseConfig);
//         firebase.analytics();
        
//         firebase.auth.Auth.Persistence.LOCAL;


// $("#btn-login").click(function(){
//     var email = $(#email_field).val();
//     var pass = $(#pass_field).val();

//     if(email != "" && pass != ""){
//         var result = firebase.auth().signInWithEmailAndPassword(email, pass);

//         result.catch(function(error){
//             var errorCode = error.code;
//             var errorMessage = error.message;

//             console.log(errorCode);
//             console.log(errorMessage);
//             window.alert("Error :" + errorMessage);
//         });
//     }
// });






// firebase.auth().onAuthStateChanged(function(user) {
//     if (user) {
//       // User is signed in.
//       window.alert("Wrong email or password")
        
//     } else {
//       // No user is signed in.
//       window.alert("Wrong email or password")
    
//     }
//   });

// function login(){

//     var userEmail = document.getElementById("email_field").value;
//     var userPass = document.getElementById("pass_field").value;

//     firebase.auth().signInWithEmailAndPassword(userEmail, userPass).catch(function(error) {
//         // Handle Errors here.
//         var errorCode = error.code;
//         var errorMessage = error.message;

//         window.alert("Error :" + errorMessage);
        
//       });

// }







// (function ($) {
//     "use strict";

//     /*==================================================================
//     [ Focus Contact2 ]*/
//     $('.input100').each(function(){
//         $(this).on('blur', function(){
//             if($(this).val().trim() != "") {
//                 $(this).addClass('has-val');
//             }
//             else {
//                 $(this).removeClass('has-val');
//             }
//         })    
//     })

//     /*==================================================================
//     [ Validate ]*/
//     var input = $('.validate-input .input100');

//     $('.validate-form').on('submit',function(){
//         var check = true;

//         for(var i=0; i<input.length; i++) {
//             if(validate(input[i]) == false){
//                 showValidate(input[i]);
//                 check=false;
//             }
//         }

//         return check;
//     });


//     $('.validate-form .input100').each(function(){
//         $(this).focus(function(){
//            hideValidate(this);
//         });
//     });

//     function validate (input) {
//         if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
//             if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
//                 return false;
//             }
//         }
//         else {
//             if($(input).val().trim() == ''){
//                 return false;
//             }
//         }
//     }

//     function showValidate(input) {
//         var thisAlert = $(input).parent();

//         $(thisAlert).addClass('alert-validate');
//     }

//     function hideValidate(input) {
//         var thisAlert = $(input).parent();

//         $(thisAlert).removeClass('alert-validate');
//     }
    

// })(jQuery);