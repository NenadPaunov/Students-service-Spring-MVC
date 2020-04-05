jQuery(function($) {
		var validation_holder;

		$("form#register_form input[name='submit']")
				.click(
						function() {

							var validation_holder = 0;

							var fname = $(
									"form#register_form input[name='firstName']")
									.val();
							var lname = $(
									"form#register_form input[name='lastName']")
									.val();
							var email = $(
									"form#register_form input[name='email']")
									.val();
							var email_regex = /^[\w%_\-.\d]+@[\w.\-]+.[A-Za-z]{2,6}$/; // reg ex email check	
							var address = $(
							"form#register_form input[name='address']")
							.val();
							var phone = $(
									"form#register_form input[name='phone']")
									.val();
							var phone_regex = /^[0-9]{6,20}$/; // reg ex phone check	
							
							/* validation start */
							if (fname == "") {
								$("span.val_fname").html(
										"This field is required.").addClass(
										'validate');
								validation_holder = 1;
							} else {
								$("span.val_fname").html("");
							}
							if (lname == "") {
								$("span.val_lname").html(
										"This field is required.").addClass(
										'validate');
								validation_holder = 1;
							} else {
								$("span.val_lname").html("");
							}
							if (!email_regex.test(email)) { // if invalid email
								$("span.val_email").html("Invalid Email!")
										.addClass('validate');
								validation_holder = 1;
							} else {
								$("span.val_email").html("");
							}
							if (address == "") {
								$("span.val_address").html(
										"This field is required.").addClass(
										'validate');
								validation_holder = 1;
							} else {
								$("span.val_lname").html("");
							}
							if (!phone_regex.test(phone)) { // if invalid phone
								$("span.val_phone").html(
										"Invalid Phone Number!").addClass(
										'validate');
								validation_holder = 1;

							} else {
								$("span.val_phone").html("");
							}
						
							if (validation_holder == 1) { // if have a field is blank, return false
								$("p.validate_msg").slideDown("fast");
								return false;
							}
							validation_holder = 0; // else return true
							/* validation end */
						}); // click end 

	});