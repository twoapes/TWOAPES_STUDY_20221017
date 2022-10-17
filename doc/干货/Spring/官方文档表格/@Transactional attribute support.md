# @Transactional attribute support

Attribute|Supported for test&#45;managed transactions
--|--
value and transactionManager|yes
propagation|only Propagation.NOT_SUPPORTED and Propagation.NEVER are supported
isolation|no
timeout|no
readOnly|no
rollbackFor and rollbackForClassName|no&#58; use TestTransaction.flagForRollback() instead
noRollbackFor and noRollbackForClassName|no&#58; use TestTransaction.flagForCommit() instead
