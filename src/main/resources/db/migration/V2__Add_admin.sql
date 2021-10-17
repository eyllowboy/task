insert into users (id, email, password, username)
    values (1, 'admin@ya.ru', '$2a$12$so63LPhGncQj8BqqpFJMEuLgnII06XxW64SfYd82fogUqJQEu5v8q', 'admin'),
            (2, 'user@ya.ru', '$2a$12$Z6ONOLjiUZIkCBCaxwawKu0b6rCITC6.Kr0LuKDYFHgf0zywltbHG', 'user');

insert into roles (id, name )
    values (1, 'ADMIN'),(2,'USER');

insert into users_roles (user_id, role_id)
    values (1 ,1), (2,2);