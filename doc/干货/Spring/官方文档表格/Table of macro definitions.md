# Table of macro definitions

macro|FTL definition
--|--
message (output a string from a resource bundle based on the code parameter)|&#60;@spring.message code&#47;&#62;
messageText (output a string from a resource bundle based on the code parameter, falling back to the value of the default parameter)|&#60;@spring.messageText code, text&#47;&#62;
url (prefix a relative URL with the application’s context root)|&#60;@spring.url relativeUrl&#47;&#62;
formInput (standard input field for gathering user input)|&#60;@spring.formInput path, attributes, fieldType&#47;&#62;
formHiddenInput (hidden input field for submitting non&#45;user input)|&#60;@spring.formHiddenInput path, attributes&#47;&#62;
formPasswordInput (standard input field for gathering passwords. Note that no value is ever populated in fields of this type.)|&#60;@spring.formPasswordInput path, attributes&#47;&#62;
formTextarea (large text field for gathering long, freeform text input)|&#60;@spring.formTextarea path, attributes&#47;&#62;
formSingleSelect (drop down box of options that let a single required value be selected)|&#60;@spring.formSingleSelect path, options, attributes&#47;&#62;
formMultiSelect (a list box of options that let the user select 0 or more values)|&#60;@spring.formMultiSelect path, options, attributes&#47;&#62;
formRadioButtons (a set of radio buttons that let a single selection be made from the available choices)|&#60;@spring.formRadioButtons path, options separator, attributes&#47;&#62;
formCheckboxes (a set of checkboxes that let 0 or more values be selected)|&#60;@spring.formCheckboxes path, options, separator, attributes&#47;&#62;
formCheckbox (a single checkbox)|&#60;@spring.formCheckbox path, attributes&#47;&#62;
showErrors (simplify display of validation errors for the bound field)|&#60;@spring.showErrors separator, classOrStyle&#47;&#62;
