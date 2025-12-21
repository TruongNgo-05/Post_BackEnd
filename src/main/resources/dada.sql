create database vti_post;

use vti_post;

CREATE TABLE post (
                      id INT AUTO_INCREMENT PRIMARY KEY,

                      title VARCHAR(50) NOT NULL,
                      description VARCHAR(100) NOT NULL,
                      content VARCHAR(150) NOT NULL,

                      created_at DATETIME NOT NULL
                          DEFAULT CURRENT_TIMESTAMP,

                      updated_at DATETIME NOT NULL
                          DEFAULT CURRENT_TIMESTAMP
                          ON UPDATE CURRENT_TIMESTAMP
);
CREATE TABLE comment (
                         id INT AUTO_INCREMENT PRIMARY KEY,

                         name VARCHAR(50) NOT NULL,
                         email VARCHAR(100) NOT NULL unique ,
                         content TEXT,

                         created_at DATETIME NOT NULL
                             DEFAULT CURRENT_TIMESTAMP,

                         updated_at DATETIME NOT NULL
                             DEFAULT CURRENT_TIMESTAMP
                             ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO post (title, description, content)
VALUES ('Post 1', 'Mo ta', 'Noi dung');

INSERT INTO comment (name, email, content)
VALUES ('Truong', 'truong@gmail.com', 'Comment lan 1');