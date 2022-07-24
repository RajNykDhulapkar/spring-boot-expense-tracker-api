DELETE FROM "et_transactions";
DELETE FROM "et_categories";
DELETE FROM "et_users";


INSERT INTO "et_users" 
(user_id, first_name, last_name, email, password) 
VALUES 
(1, 'Raj', 'Naik Dhulapkar', 'rajdhulapkar@gmail.com', '$2a$10$l5SV6zTUZ/8ezs1Smf62teapVkVGRFHsY91o4vOBQt/xcsAjRzaam'),
(2, 'Jane', 'Doe', 'janedoe@gmail.com', '$2a$10$l5SV6zTUZ/8ezs1Smf62teapVkVGRFHsY91o4vOBQt/xcsAjRzaam');

INSERT INTO "et_categories" 
(category_id, user_id, title, description) 
VALUES 
(1, 1, 'Grocery', 'Money spent on buying grocery'),
(2, 1, 'Fuel', 'Money Spent on Fuel'),
(3, 1, 'Car Maintainence', 'Money spent on car maintainence'),
(4, 1, 'Rent', 'Rent paid to the landlord'),
(5, 1, 'Cable', 'Cable subscription fee'),
(6, 1, 'Office Supplies', 'stationery and office supplies'),
(7, 1, 'Food & Drinks', 'Money spent on eating out'),
(8, 1, 'Gym Fees', 'Money spent on he gym subscription'),
(9, 1, 'ISP Bill', 'Internet connection subscription'),
(10, 1, 'Electronic parts', 'Money spent on  elecl comp'),
(11, 2, 'Grocery', 'Money spent on buying grocery'),
(12, 2, 'Fuel', 'Money Spent on Fuel'),
(13, 2, 'Food & Drinks', 'Money spent on eating out'),
(14, 2, 'Gym Fees', 'Money spent on the gym subscription'),
(15, 2, 'Acting class Fees', 'Money spent on acting class subscription');



