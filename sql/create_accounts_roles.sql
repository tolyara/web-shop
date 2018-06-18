	
create table accounts (
  account_name         varchar(15) not null primary key,
  account_pass         varchar(15) not null
);

create table account_roles (
  account_role_id serial PRIMARY KEY,
  account_name         varchar(15) not null,
  role_name            varchar(15) not null,  
);

INSERT INTO accounts (account_name, account_pass) VALUES ('Admin', '1234');
INSERT INTO accounts (account_name, account_pass) VALUES ('User', '5678');

INSERT INTO account_roles (account_name, role_name) VALUES ('Admin', 'admin');
INSERT INTO account_roles (account_name, role_name) VALUES ('User', 'user');








