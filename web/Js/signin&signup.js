$(document)
.ready(function() {
        // Hide Sign Up side on initialization
  $( '.inactive' ).hide();
  
  $( '.mini.button.signup' ).click(function() {
 
    // Hide Sign In and show Sign Up side with slide down effect
    $( '.ui.grid.signin' )
      .hide()
      .end()
    .find( '.ui.grid.signup' )
      .slideDown();
  });
 
 
  $( '.mini.button.signin' ).click(function() {
 
    // Hide Sign Up and show Sign In side with slide down effect
    $( '.ui.grid.signup' )
      .hide()
      .end()
    .find( '.ui.grid.signin' )
      .slideDown();
 
  });
   
      $('.ui.form')
        .form({
          fields: {
            username: {
              identifier  : 'username',
              rules: [
                {
                  type   : 'empty',
                  prompt : 'Please enter your username'
                },
              ]
            },
            password: {
              identifier  : 'password',
              rules: [
                {
                  type   : 'empty',
                  prompt : 'Please enter your password'
                },
                {
                  type   : 'length[6]',
                  prompt : 'Your password must be at least 6 characters'
                }
              ]
            },
            passwordConfirm:{
              identifier : 'confirm-password',
              rules:[
                {
                  type   : 'empty',
                  prompt : 'Please confirm your password'
                },
                {
                  type   : 'match[password]',
                  prompt : 'Password doesn\'t match'
                }
              ]
            }
          }
        });
    })
  ;