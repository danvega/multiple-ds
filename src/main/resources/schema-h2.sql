DROP TABLE IF EXISTS Subscriber;

CREATE TABLE Subscriber (
    id int NOT NULL,
    name varchar(255) NOT NULL,
    email varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO Subscriber
(id, name, email) values ( 1, 'Dan Vega', 'danvega@gmaillcom' )