var firebaseConfig = {
    apiKey: "AIzaSyBfAiv3e-9SwsdgN2Ey2Hrdi6dt-P7RMCM",
    authDomain: "fypcatalog-ca80c.firebaseapp.com",
    databaseURL: "https://fypcatalog-ca80c.firebaseio.com",
    projectId: "fypcatalog-ca80c",
    storageBucket: "fypcatalog-ca80c.appspot.com",
    messagingSenderId: "900761097193",
    appId: "1:900761097193:web:df6d13bfe738e77514f178"
  };
  // Initialize Firebase
  firebase.initializeApp(firebaseConfig);

  firebase.auth.Auth.Persistence.LOCAL;


  $("#btn-login").click(function(){
      var email = $("#email").val ();
      var password = $("#pass").val();

      if(email != "" & password != "")
      {
        var result = firebase.auth().signInWithEmailAndPassword(email, password);

        result.catch(function(error)
        {
            var errorCode = error.code;
            var errorMessage = error.message;

            console.log(errorCode);
            console.log(errorMessage);

            window.alert("Message: " + errorMessage);
        });
        
      }
      else
      {
          window.alert("Please enter the correct email and password.")
      }
  });

  $("#btn-logout").click(function()
  {
      firebase.auth().signOut();
  });