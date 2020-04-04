jQuery(function($) {
		var validation_holder;

		$("form#register_form input[name='submit']")
				.click(
						function() {

							var validation_holder = 0;

							var cityName = $(
									"form#register_form input[name='cityName']")
									.val();
							var zipCode = $(
							"form#register_form input[name='zipCode']")
							.val();
							

							/* validation start */
							if (cityName == "") {
								$("span.val_cityName").html(
										"This field is required.").addClass(
										'validate');
								validation_holder = 1;
							} else {
								$("span.val_cityName").html("");
							}
							if (zipCode == "") {
								$("span.val_zipCode").html(
										"This field is required.").addClass(
										'validate');
								validation_holder = 1;
							} else {
								$("span.val_zipCode").html("");
							}
							
							if (validation_holder == 1) { // if have a field is blank, return false
								$("p.validate_msg").slideDown("fast");
								return false;
							}
							validation_holder = 0; // else return true
							/* validation end */
						}); // click end 

	});