(function() {

  const redirectIfLoggedIn = async () => {
    const isLoggedIn = await firebaseUtils.isLoggedIn();
    if (isLoggedIn) {
      window.location.href = 'table.html';
    }
  };

  redirectIfLoggedIn();

  const loginBtn  = $('#btn-login');
  const logoutBtn = $('#btn-logout');

  loginBtn.click(async () => {
    const email       = $('#email').val();
    const password    = $('#pass').val();

    if (!email || !password) {
      window.alert('Please enter the email and password.');
      return;
    }
  
    try {
      await firebaseUtils.login(email, password);
    } catch (error) {
      const errorMessage = error.message;
      window.alert('Message: ' + errorMessage);
    }
  });

  logoutBtn.click(async () => {
    await firebaseUtils.logout();
  });
})(); 
  