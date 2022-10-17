# @Transactional Settings

Property|Type|Description
--|--|--
value|String|Optional qualifier that specifies the transaction manager to be used.
transactionManager|String|Alias for value.
label|Array of String labels to add an expressive description to the transaction.|Labels may be evaluated by transaction managers to associate implementation&#45;specific behavior with the actual transaction.
propagation|enum&#58; Propagation|Optional propagation setting.
isolation|enum&#58; Isolation|Optional isolation level. Applies only to propagation values of REQUIRED or REQUIRES_NEW.
timeout|int (in seconds of granularity)|Optional transaction timeout. Applies only to propagation values of REQUIRED or REQUIRES_NEW.
timeoutString|String (in seconds of granularity)|Alternative for specifying the timeout in seconds as a String value — for example, as a placeholder.
readOnly|boolean|Read&#45;write versus read&#45;only transaction. Only applicable to values of REQUIRED or REQUIRES_NEW.
rollbackFor|Array of Class objects, which must be derived from Throwable.|Optional array of exception types that must cause rollback.
rollbackForClassName|Array of exception name patterns.|Optional array of exception name patterns that must cause rollback.
noRollbackFor|Array of Class objects, which must be derived from Throwable.|Optional array of exception types that must not cause rollback.
noRollbackForClassName|Array of exception name patterns.|Optional array of exception name patterns that must not cause rollback.
