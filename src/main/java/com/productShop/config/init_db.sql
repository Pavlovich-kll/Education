DROP TABLE IF EXISTS userConsumer;
DROP TABLE IF EXISTS basket;
DROP TABLE IF EXISTS basketList;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS productList;
DROP TABLE IF EXISTS productType;

CREATE TABLE userConsumer
(
    userID          CHAR(36) NOT NULL PRIMARY KEY,
    login           TEXT     NOT NULL,
    password        TEXT     NOT NULL
);

CREATE TABLE productType
(
    productTypeID   SERIAL   NOT NULL PRIMARY KEY,
    typeProduct        TEXT     NOT NULL unique
);

CREATE TABLE product
(
    productID       SERIAL   NOT NULL PRIMARY KEY,
--     basketID        INTEGER  NOT NULL REFERENCES basket (basketID),
    nameProduct     TEXT     NOT NULL,
    typeName        TEXT  NOT NULL REFERENCES productType (typeName)ON DELETE CASCADE,
    price           INTEGER  NOT NULL
);

CREATE TABLE productList
(
    productListID   SERIAL   NOT NULL PRIMARY KEY,
    productID       SERIAL   NOT NULL REFERENCES product (productID)ON DELETE CASCADE,
--     basketID        INTEGER  NOT NULL REFERENCES basket (basketID),
    nameProduct     TEXT     NOT NULL,
    typeName        TEXT     NOT NULL,
    price           INTEGER  NOT NULL
);

CREATE TABLE basket
(
    basketID        SERIAL   NOT NULL PRIMARY KEY,
    userID          CHAR(36) NOT NULL REFERENCES userConsumer (userID) ON DELETE CASCADE,
    productID       INTEGER  NOT NULL REFERENCES product (productID) ON DELETE CASCADE,
    count           INTEGER  NOT NULL
);

CREATE TABLE basketList
(
    basketListID    SERIAL   NOT NULL PRIMARY KEY,
    basketID        SERIAL   NOT NULL REFERENCES basket (basketID)ON DELETE CASCADE,
    userID          CHAR(36) NOT NULL REFERENCES userConsumer (userID)ON DELETE CASCADE,
    nameProduct     TEXT     NOT NULL,
    typeName        TEXT     NOT NULL,
    price           INTEGER  NOT NULL,
    count           INTEGER  NOT NULL
);
