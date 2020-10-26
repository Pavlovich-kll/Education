CREATE TABLE userConsumer
(
    userID          CHAR(36) NOT NULL PRIMARY KEY,
    login           TEXT     NOT NULL,
    password        TEXT     NOT NULL
);

CREATE TABLE basket
(
    basketID        SERIAL   NOT NULL PRIMARY KEY,
    userID          CHAR(36) NOT NULL REFERENCES userConsumer (userID),
    product         TEXT     NOT NULL,
    count           INTEGER  NOT NULL
);

CREATE TABLE product
(
    productID       SERIAL   NOT NULL PRIMARY KEY,
    basketID        INTEGER  NOT NULL REFERENCES basket (basketID),
    name            TEXT     NOT NULL,
    type            INTEGER  NOT NULL,
    price           INTEGER  NOT NULL
);

CREATE TABLE productType
(
    productTypeID   SERIAL  NOT NULL,
    productID       INTEGER  NOT NULL REFERENCES product (productID),
    typeName        TEXT    NOT NULL
);