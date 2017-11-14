--------------------------------------------------------
--  DDL for Table dict_account_type
--------------------------------------------------------

CREATE TABLE dict_account_type(
    id NUMBER(10,0),
    text CHAR(80),
    english CHAR(30),
    iconurl CHAR(50),
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table dict_trade_status
--------------------------------------------------------

CREATE TABLE dict_trade_status(
    id NUMBER(10,0),
    text CHAR(80),
    english CHAR(30),
    iconurl CHAR(50),
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table dict_trade_type
--------------------------------------------------------

CREATE TABLE dict_trade_type(
    id NUMBER(10,0),
    text CHAR(80),
    english CHAR(30),
    iconurl CHAR(50),
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table dict_adjust_type
--------------------------------------------------------

CREATE TABLE dict_adjust_type(
    id NUMBER(10,0),
    text CHAR(80),
    english CHAR(30),
    iconurl CHAR(50),
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table dict_reconciliation_status
--------------------------------------------------------

CREATE TABLE dict_reconciliation_status(
    id NUMBER(10,0),
    text CHAR(80),
    english CHAR(30),
    iconurl CHAR(50),
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_account
--------------------------------------------------------

CREATE TABLE tbl_account(
    id NUMBER(19,0),
    version NUMBER(10,0) NOT NULL,
    lowlimit NUMBER(19,0) NOT NULL,
    lastcardtime DATE,
    canwithdraw NUMBER(1,0) NOT NULL,
    expireddate DATE,
    type NUMBER(10,0) NOT NULL,
    freezeamt NUMBER(19,0) NOT NULL,
    issuer_id NUMBER(10,0),
    mac CHAR(8),
    totalincome NUMBER(19,0) NOT NULL,
    balance NUMBER(19,0) NOT NULL,
    createtime DATE,
    lastestincome NUMBER(19,0) NOT NULL,
    status NUMBER(10,0) NOT NULL,
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_commondict
--------------------------------------------------------

CREATE TABLE tbl_commondict(
    id NUMBER(10,0),
    version NUMBER(10,0) NOT NULL,
    english VARCHAR2(255),
    iconurl VARCHAR2(255),
    text VARCHAR2(255),
    category VARCHAR2(255),
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_eaikey
--------------------------------------------------------

CREATE TABLE tbl_eaikey(
    id NUMBER(10,0),
    version NUMBER(10,0) NOT NULL,
    posid VARCHAR2(255),
    registertime DATE,
    keytext VARCHAR2(255),
    invaliddate DATE,
    serverid NUMBER(19,0) NOT NULL,
    key VARCHAR2(255),
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_magicsession
--------------------------------------------------------

CREATE TABLE tbl_magicsession(
    id VARCHAR2(32),
    registertime DATE,
    ipaddress VARCHAR2(255),
    lastaccess DATE,
    usertype NUMBER(10,0),
    userid NUMBER(19,0),
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_mobileusertoken
--------------------------------------------------------

CREATE TABLE tbl_mobileusertoken(
    id RAW(32),
    version NUMBER(10,0) NOT NULL,
    recordtime DATE,
    accesskey VARCHAR2(255),
    lastupdate DATE,
    ipaddress VARCHAR2(255),
    type NUMBER(10,0) NOT NULL,
    userid NUMBER(19,0),
    status NUMBER(10,0) NOT NULL,
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_module
--------------------------------------------------------

CREATE TABLE tbl_module(
    id NUMBER(10,0),
    version NUMBER(10,0) NOT NULL,
    parent_id NUMBER(10,0),
    description VARCHAR2(255),
    moduleindex NUMBER(10,0) NOT NULL,
    acceptedip VARCHAR2(255),
    cond VARCHAR2(255),
    layer NUMBER(10,0) NOT NULL,
    logourl VARCHAR2(255),
    name VARCHAR2(255),
    orglevels VARCHAR2(255),
    pageurl VARCHAR2(255),
    iconurl VARCHAR2(255),
    actions VARCHAR2(255),
    uniqueid VARCHAR2(255),
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_mysequence
--------------------------------------------------------

CREATE TABLE tbl_mysequence(
    id VARCHAR2(32),
    nextcount NUMBER(19,0) NOT NULL,
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_organization
--------------------------------------------------------

CREATE TABLE tbl_organization(
    id NUMBER(10,0),
    version NUMBER(10,0) NOT NULL,
    country NUMBER(10,0) NOT NULL,
    p1 NUMBER(19,0),
    parent_id NUMBER(10,0),
    clearparent_id NUMBER(10,0),
    description CHAR(255),
    orglevel NUMBER(10,0) NOT NULL,
    invalidtime DATE,
    ismerchant NUMBER(1,0) NOT NULL,
    enabled NUMBER(10,0) NOT NULL,
    password CHAR(40),
    cardunique CHAR(16),
    idexpiredate DATE,
    isagent NUMBER(1,0) NOT NULL,
    province NUMBER(10,0) NOT NULL,
    usecreditdeposit NUMBER(1,0) NOT NULL,
    email CHAR(96),
    address CHAR(160),
    registertime DATE,
    isissuer NUMBER(1,0) NOT NULL,
    fullname CHAR(128),
    idno CHAR(24),
    logourl CHAR(40),
    isinternal NUMBER(1,0) NOT NULL,
    p300 NUMBER(19,0),
    p200 NUMBER(19,0),
    p700 NUMBER(19,0),
    p600 NUMBER(19,0),
    phone CHAR(24),
    p500 NUMBER(19,0),
    p400 NUMBER(19,0),
    name CHAR(128),
    p800 NUMBER(19,0),
    olduniqueid CHAR(64),
    uniqueid CHAR(24) UNIQUE,
    status NUMBER(10,0) NOT NULL,
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_partner
--------------------------------------------------------

CREATE TABLE tbl_partner(
    id NUMBER(10,0),
    version NUMBER(10,0) NOT NULL,
    enckey VARCHAR2(255),
    checkip NUMBER(1,0),
    api_level CLOB,
    name VARCHAR2(50),
    interfaceversion VARCHAR2(255),
    servicetypes CLOB,
    signkey VARCHAR2(255),
    partnerid VARCHAR2(15) UNIQUE,
    ips CLOB,
    signmethod NUMBER(10,0) NOT NULL,
    encmethod NUMBER(10,0) NOT NULL,
    status NUMBER(10,0) NOT NULL,
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_persistkey
--------------------------------------------------------

CREATE TABLE tbl_persistkey(
    id NUMBER(10,0),
    version NUMBER(10,0) NOT NULL,
    keyversion NUMBER(3,0) NOT NULL,
    jmjindex NUMBER(10,0) NOT NULL,
    keyindex NUMBER(3,0) NOT NULL,
    name VARCHAR2(255),
    keyid NUMBER(3,0) NOT NULL,
    encryptkey VARCHAR2(255),
    keytype NUMBER(3,0) NOT NULL,
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_pkikey
--------------------------------------------------------

CREATE TABLE tbl_pkikey(
    id NUMBER(10,0),
    version NUMBER(10,0) NOT NULL,
    createtime DATE,
    privatekeytext CLOB,
    publickeytext CLOB,
    uniqueid VARCHAR2(255) UNIQUE,
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_poskey
--------------------------------------------------------

CREATE TABLE tbl_poskey(
    id NUMBER(10,0),
    version NUMBER(10,0) NOT NULL,
    posid VARCHAR2(255) UNIQUE,
    registertime DATE,
    keytext VARCHAR2(255),
    trackkey VARCHAR2(255),
    mainkey VARCHAR2(255),
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_profilelog
--------------------------------------------------------

CREATE TABLE tbl_profilelog(
    id NUMBER(10,0),
    version NUMBER(10,0) NOT NULL,
    recorddate DATE,
    serverip CHAR(32),
    threadcount NUMBER(10,0) NOT NULL,
    transactions NUMBER(19,0),
    freememory NUMBER(19,0) NOT NULL,
    maxmemory NUMBER(19,0) NOT NULL,
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_property
--------------------------------------------------------

CREATE TABLE tbl_property(
    id NUMBER(10,0),
    version NUMBER(10,0) NOT NULL,
    entityname CHAR(32),
    name CHAR(64),
    entityid NUMBER(19,0),
    value CHAR(128),
    uniqueid CHAR(64) UNIQUE,
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_singletasklock
--------------------------------------------------------

CREATE TABLE tbl_singletasklock(
    id NUMBER(10,0),
    version NUMBER(10,0) NOT NULL,
    code VARCHAR2(255) UNIQUE,
    begintime DATE,
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_taskdef
--------------------------------------------------------

CREATE TABLE tbl_taskdef(
    id NUMBER(10,0),
    version NUMBER(10,0) NOT NULL,
    singleton NUMBER(1,0) NOT NULL,
    period NUMBER(19,0) NOT NULL,
    code VARCHAR2(255) UNIQUE,
    threads NUMBER(10,0) NOT NULL,
    delayeachthread NUMBER(10,0) NOT NULL,
    enabled NUMBER(1,0) NOT NULL,
    servers VARCHAR2(255),
    month VARCHAR2(255),
    dayofmonth VARCHAR2(255),
    name VARCHAR2(255) UNIQUE,
    action VARCHAR2(255),
    time VARCHAR2(255),
    day VARCHAR2(255),
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  DDL for Table tbl_usertoken
--------------------------------------------------------

CREATE TABLE tbl_usertoken(
    id NUMBER(19,0),
    version NUMBER(10,0) NOT NULL,
    recordtime DATE,
    lastupdate DATE,
    usertoken VARCHAR2(255) UNIQUE,
    status NUMBER(10,0) NOT NULL,
    PRIMARY KEY(id)
)  ;
--------------------------------------------------------
--  Ref Constraints for Table tbl_account
--------------------------------------------------------

ALTER TABLE tbl_account ADD CONSTRAINT fk_account_issuer FOREIGN KEY (issuer_id) 
  REFERENCES tbl_organization;
--------------------------------------------------------
--  Ref Constraints for Table tbl_module
--------------------------------------------------------

ALTER TABLE tbl_module ADD CONSTRAINT fk_module_parent FOREIGN KEY (parent_id) 
  REFERENCES tbl_module;
--------------------------------------------------------
--  Ref Constraints for Table tbl_organization
--------------------------------------------------------

ALTER TABLE tbl_organization ADD CONSTRAINT fk_organization_parent FOREIGN KEY (parent_id) 
  REFERENCES tbl_organization;
ALTER TABLE tbl_organization ADD CONSTRAINT fk_organization_clearparent FOREIGN KEY (clearparent_id) 
  REFERENCES tbl_organization;
--------------------------------------------------------
--  DDL for Sequence seq_account
--------------------------------------------------------

CREATE SEQUENCE seq_account START WITH 100000000000 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence seq_eaikey
--------------------------------------------------------

CREATE SEQUENCE seq_eaikey START WITH 100000 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence seq_module
--------------------------------------------------------

CREATE SEQUENCE seq_module START WITH 100000 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence seq_organization
--------------------------------------------------------

CREATE SEQUENCE seq_organization START WITH 100000 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence seq_partner
--------------------------------------------------------

CREATE SEQUENCE seq_partner START WITH 100000 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence seq_persistkey
--------------------------------------------------------

CREATE SEQUENCE seq_persistkey START WITH 100000 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence seq_pkikey
--------------------------------------------------------

CREATE SEQUENCE seq_pkikey START WITH 100000 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence seq_poskey
--------------------------------------------------------

CREATE SEQUENCE seq_poskey START WITH 100000 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence seq_profilelog
--------------------------------------------------------

CREATE SEQUENCE seq_profilelog START WITH 100000 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence seq_property
--------------------------------------------------------

CREATE SEQUENCE seq_property START WITH 100000 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence seq_singletasklock
--------------------------------------------------------

CREATE SEQUENCE seq_singletasklock START WITH 100000 INCREMENT BY 1;
--------------------------------------------------------
--  DDL for Sequence seq_taskdef
--------------------------------------------------------

CREATE SEQUENCE seq_taskdef START WITH 100000 INCREMENT BY 1;
--------------------------------------------------------
--  Indexes for Table tbl_account
--------------------------------------------------------

CREATE INDEX ind_account_issuer ON tbl_account (issuer_id);
--------------------------------------------------------
--  Indexes for Table tbl_eaikey
--------------------------------------------------------

CREATE INDEX ind_eaikey_posid ON tbl_eaikey (posid);
--------------------------------------------------------
--  Indexes for Table tbl_module
--------------------------------------------------------

CREATE INDEX ind_module_parent ON tbl_module (parent_id);
--------------------------------------------------------
--  Indexes for Table tbl_organization
--------------------------------------------------------

CREATE INDEX ind_organization_cardunique ON tbl_organization (cardunique);
CREATE INDEX ind_organization_olduniqueid ON tbl_organization (olduniqueid);
CREATE INDEX ind_organization_parent ON tbl_organization (parent_id);
CREATE INDEX ind_organization_clearparent ON tbl_organization (clearparent_id);
--------------------------------------------------------
--  Indexes for Table tbl_usertoken
--------------------------------------------------------

CREATE INDEX ind_usertoken_recordtime ON tbl_usertoken (recordtime);
