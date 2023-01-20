CREATE TABLE IF NOT EXISTS hospital(
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    telefone VARCHAR(11) NOT NULL,
    CONSTRAINT hospital_pkey PRIMARY KEY (id)
);

INSERT INTO
    hospital(nome, endereco, telefone)
VALUES
    ('Hospital Um', 'Rua um, 1', '11912457891'),
    ('Hospital Dois', 'Rua dois, 12', '11912457892'),
    ('Hospital Tres', 'Rua tres, 123', '11912457893'),
    ('Hospital Quatro', 'Rua quatro, 1234', '11912457894'),
    ('Hospital Cinco', 'Rua cinco, 12345', '11912457895');