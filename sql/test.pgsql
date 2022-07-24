SELECT * FROM "et_users";
SELECT * FROM "et_categories";
SELECT * FROM "et_transactions";

-- DELETE FROM "et_transactions";
-- DELETE FROM "et_categories";
-- DELETE FROM "et_users";

-- INSERT INTO "et_users" 
-- (user_id, first_name, last_name, email, password) 
-- VALUES 
-- (nextval('ET_USERS_SEQ'), 'Raj', 'Dhulapkar', 'rajnak@gmail.com', 'password'),
-- (nextval('ET_USERS_SEQ'), 'Pari', 'Dhulapkar', 'paridhulapkar@gmail.com', 'nextpassword'),
-- (nextval('ET_USERS_SEQ'), 'John', 'Doe', 'johndoe@gmail.com', 'newerpassword');

-- SELECT * FROM "et_users";
-- DELETE FROM "et_categories";

-- INSERT INTO "et_categories" 
-- (category_id, user_id, title, description) 
-- VALUES 
-- (nextval('ET_CATEGORIES_SEQ'), 16, 'Shopping Expense', 'Money spent on shopping'),
-- (nextval('ET_CATEGORIES_SEQ'), 16, 'Acting Class Fees', 'Money spent on paying fees of acting class'),
-- (nextval('ET_CATEGORIES_SEQ'), 16, 'Fuel', 'Money spent on fuel');

-- SELECT * FROM "et_categories";

-- UPDATE "et_categories" 
-- SET title = 'Shopping', description = 'This is all the money spent on shopping'
-- WHERE user_id = 16 AND category_id = 22;

-- SELECT * FROM "et_categories";