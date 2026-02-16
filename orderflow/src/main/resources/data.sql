-- Inserindo role ADMIN
INSERT INTO Roles (id, authority) VALUES (1, 'ROLE_ADMIN');

-- Inserindo usuário admin (senha já criptografada com BCrypt: "123456")
INSERT INTO Usuario (id, username, password)
VALUES (1, 'admin', '$2a$10$7QfZkzYlZpQyYfQhYfQhYfQhYfQhYfQhYfQhYfQhYfQhYfQhYfQh');

-- Relacionando usuário admin com role ADMIN
INSERT INTO UsuarioPerfil (user_id, role_id) VALUES (1, 1);