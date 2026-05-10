USE tienda_comics_db;


INSERT INTO dueños (nombre) VALUES ('Carlos Perez'), ('Maria Lopez');

INSERT INTO editoriales (nombre) VALUES ('Marvel Comics'), ('DC Comics'), ('Dark Horse');

INSERT INTO categorias (nombre) VALUES ('Superhéroes'), ('Manga'), ('Ciencia Ficción');

INSERT INTO autores (nombre) VALUES ('Stan Lee'), ('Frank Miller'), ('Alan Moore');


INSERT INTO clientes (nombre, apellido, edad, rut, dv, correo, telefono, direccion) 
VALUES 
('Juan', 'Soto', 25, 12345678, '9', 'juan.soto@gmail.com', 987654321, 'Av. Siempre Viva 123'),
('Pedro', 'Pascal', 48, 11223344, '5', 'pedro.pascal@gmail.com', 998877665, 'Calle Falsa 456');

INSERT INTO empleados (nombre, apellido, edad, rut, dv, correo, telefono) 
VALUES 
('Ana', 'Gomez', 30, 87654321, 'K', 'ana.gomez@tienda.cl', 912345678);

INSERT INTO tiendas (nombre_tienda, direccion_tienda, id_dueño) 
VALUES ('Comics Center', 'Paseo Ahumada 123', 1);

INSERT INTO comics (titulo, isbn, genero, precio, fecha_publicacion, stock) 
VALUES 
('Batman: Año Uno', '9781401207526', 'Acción', 15000, '1987-02-01', 10),
('Spider-Man: Origen', '9780785124986', 'Acción', 12000, '1962-08-01', 5);


----------------
Para probar en postman

(CREAR NUEVO CLIENTE)

{
  "nombre": "Sofia",
  "apellido": "Vergara",
  "edad": 35,
  "rut": 18765432,
  "dv": "1",
  "correo": "sofia.v@gmail.com",
  "telefono": 944556677,
  "direccion": "Av. Las Condes 789"
}

-----------------------------
(CREAR NUEVO COMIC)

{
  "titulo": "Watchmen",
  "isbn": "9781401245252",
  "genero": "Novela Gráfica",
  "precio": 25000.0,
  "fechaPublicacion": "1986-09-01",
  "stock": 15
}


-------------------------------
(MODIFICAR UN COMIC (POR ID))

{
  "titulo": "Watchmen Edición Deluxe",
  "isbn": "9781401245252",
  "genero": "Novela Gráfica",
  "precio": 28000.0,
  "fechaPublicacion": "1986-09-01",
  "stock": 14
}