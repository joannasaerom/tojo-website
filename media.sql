--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: sunglasses; Type: TABLE; Schema: public; Owner: joannaanderson
--

CREATE TABLE sunglasses (
    id integer NOT NULL,
    name character varying,
    imgurl character varying,
    description character varying,
    price integer,
    customerid integer
);


ALTER TABLE sunglasses OWNER TO joannaanderson;

--
-- Name: sunglasses_id_seq; Type: SEQUENCE; Schema: public; Owner: joannaanderson
--

CREATE SEQUENCE sunglasses_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sunglasses_id_seq OWNER TO joannaanderson;

--
-- Name: sunglasses_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: joannaanderson
--

ALTER SEQUENCE sunglasses_id_seq OWNED BY sunglasses.id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: joannaanderson
--

CREATE TABLE users (
    id integer NOT NULL,
    name character varying,
    creditcardnum integer,
    phone character varying,
    email character varying,
    street character varying,
    city character varying,
    state character varying,
    zipcode integer
);


ALTER TABLE users OWNER TO joannaanderson;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: joannaanderson
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO joannaanderson;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: joannaanderson
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: joannaanderson
--

ALTER TABLE ONLY sunglasses ALTER COLUMN id SET DEFAULT nextval('sunglasses_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: joannaanderson
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- Data for Name: sunglasses; Type: TABLE DATA; Schema: public; Owner: joannaanderson
--

COPY sunglasses (id, name, imgurl, description, price, customerid) FROM stdin;
17	Classic Deep Brown	http://retrosuperfuture.com/working/media/catalog/product/cache/6/thumbnail/9df78eab33525d08d6e5fb8d27136e95/s/u/super-1layout-9l3.jpg	Banh mi freegan bicycle rights shabby chic, brunch +1 literally vinyl vice bushwick cray kickstarter. Chillwave affogato jean shorts edison bulb, raw denim taxidermy green juice semiotics post-ironic photo booth disrupt fixie iPhone. Hexagon church-key chia, raclette iPhone mustache disrupt yuccie cray tilde. Blue bottle locavore tote bag PBR&B, tousled humblebrag keytar blog before they sold out leggings truffaut. Enamel pin poke master cleanse, mixtape franzen disrupt ramps chillwave paleo pinterest XOXO raw denim 8-bit etsy. 	159	\N
18	RACER COVE II	http://retrosuperfuture.com/working/media/catalog/product/cache/6/thumbnail/9df78eab33525d08d6e5fb8d27136e95/s/u/super-1layout-vru.jpg	Banh mi freegan bicycle rights shabby chic, brunch +1 literally vinyl vice bushwick cray kickstarter. Chillwave affogato jean shorts edison bulb, raw denim taxidermy green juice semiotics post-ironic photo booth disrupt fixie iPhone. Hexagon church-key chia, raclette iPhone mustache disrupt yuccie cray tilde. Blue bottle locavore tote bag PBR&B, tousled humblebrag keytar blog before they sold out leggings truffaut. Enamel pin poke master cleanse, mixtape franzen disrupt ramps chillwave paleo pinterest XOXO raw denim 8-bit etsy. 	179	\N
19	GIAGUARO BLACK MATTE ZERO	http://retrosuperfuture.com/working/media/catalog/product/cache/6/thumbnail/9df78eab33525d08d6e5fb8d27136e95/s/u/super-1layout-ho8.jpg	Banh mi freegan bicycle rights shabby chic, brunch +1 literally vinyl vice bushwick cray kickstarter. Chillwave affogato jean shorts edison bulb, raw denim taxidermy green juice semiotics post-ironic photo booth disrupt fixie iPhone. Hexagon church-key chia, raclette iPhone mustache disrupt yuccie cray tilde. Blue bottle locavore tote bag PBR&B, tousled humblebrag keytar blog before they sold out leggings truffaut. Enamel pin poke master cleanse, mixtape franzen disrupt ramps chillwave paleo pinterest XOXO raw denim 8-bit etsy. 	239	\N
20	GIAGUARO BLUE ZERO	http://retrosuperfuture.com/working/media/catalog/product/cache/6/thumbnail/9df78eab33525d08d6e5fb8d27136e95/s/u/super-1layout-1q1.jpg	Banh mi freegan bicycle rights shabby chic, brunch +1 literally vinyl vice bushwick cray kickstarter. Chillwave affogato jean shorts edison bulb, raw denim taxidermy green juice semiotics post-ironic photo booth disrupt fixie iPhone. Hexagon church-key chia, raclette iPhone mustache disrupt yuccie cray tilde. Blue bottle locavore tote bag PBR&B, tousled humblebrag keytar blog before they sold out leggings truffaut. Enamel pin poke master cleanse, mixtape franzen disrupt ramps chillwave paleo pinterest XOXO raw denim 8-bit etsy. 	269	\N
21	RACER DARK HAVANA	http://retrosuperfuture.com/working/media/catalog/product/cache/6/thumbnail/9df78eab33525d08d6e5fb8d27136e95/s/u/super-1layout-486.jpg	Banh mi freegan bicycle rights shabby chic, brunch +1 literally vinyl vice bushwick cray kickstarter. Chillwave affogato jean shorts edison bulb, raw denim taxidermy green juice semiotics post-ironic photo booth disrupt fixie iPhone. Hexagon church-key chia, raclette iPhone mustache disrupt yuccie cray tilde. Blue bottle locavore tote bag PBR&B, tousled humblebrag keytar blog before they sold out leggings truffaut. Enamel pin poke master cleanse, mixtape franzen disrupt ramps chillwave paleo pinterest XOXO raw denim 8-bit etsy. 	139	\N
22	OKINAWA BLACK MATTE	http://retrosuperfuture.com/working/media/catalog/product/cache/6/thumbnail/9df78eab33525d08d6e5fb8d27136e95/s/u/super-1layout-l1r.jpg	Banh mi freegan bicycle rights shabby chic, brunch +1 literally vinyl vice bushwick cray kickstarter. Chillwave affogato jean shorts edison bulb, raw denim taxidermy green juice semiotics post-ironic photo booth disrupt fixie iPhone. Hexagon church-key chia, raclette iPhone mustache disrupt yuccie cray tilde. Blue bottle locavore tote bag PBR&B, tousled humblebrag keytar blog before they sold out leggings truffaut. Enamel pin poke master cleanse, mixtape franzen disrupt ramps chillwave paleo pinterest XOXO raw denim 8-bit etsy. 	229	\N
23	PEOPLE SAGOMA	http://retrosuperfuture.com/working/media/catalog/product/cache/6/thumbnail/9df78eab33525d08d6e5fb8d27136e95/s/u/super-layout1-ejb.jpg	Banh mi freegan bicycle rights shabby chic, brunch +1 literally vinyl vice bushwick cray kickstarter. Chillwave affogato jean shorts edison bulb, raw denim taxidermy green juice semiotics post-ironic photo booth disrupt fixie iPhone. Hexagon church-key chia, raclette iPhone mustache disrupt yuccie cray tilde. Blue bottle locavore tote bag PBR&B, tousled humblebrag keytar blog before they sold out leggings truffaut. Enamel pin poke master cleanse, mixtape franzen disrupt ramps chillwave paleo pinterest XOXO raw denim 8-bit etsy. 	159	\N
24	PANAMÁ PATROL	http://retrosuperfuture.com/working/media/catalog/product/cache/6/thumbnail/9df78eab33525d08d6e5fb8d27136e95/s/u/super-1layout-kut.jpg	Banh mi freegan bicycle rights shabby chic, brunch +1 literally vinyl vice bushwick cray kickstarter. Chillwave affogato jean shorts edison bulb, raw denim taxidermy green juice semiotics post-ironic photo booth disrupt fixie iPhone. Hexagon church-key chia, raclette iPhone mustache disrupt yuccie cray tilde. Blue bottle locavore tote bag PBR&B, tousled humblebrag keytar blog before they sold out leggings truffaut. Enamel pin poke master cleanse, mixtape franzen disrupt ramps chillwave paleo pinterest XOXO raw denim 8-bit etsy. 	209	\N
\.


--
-- Name: sunglasses_id_seq; Type: SEQUENCE SET; Schema: public; Owner: joannaanderson
--

SELECT pg_catalog.setval('sunglasses_id_seq', 24, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: joannaanderson
--

COPY users (id, name, creditcardnum, phone, email, street, city, state, zipcode) FROM stdin;
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: joannaanderson
--

SELECT pg_catalog.setval('users_id_seq', 1, false);


--
-- Name: sunglasses_pkey; Type: CONSTRAINT; Schema: public; Owner: joannaanderson
--

ALTER TABLE ONLY sunglasses
    ADD CONSTRAINT sunglasses_pkey PRIMARY KEY (id);


--
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: joannaanderson
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: public; Type: ACL; Schema: -; Owner: joannaanderson
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM joannaanderson;
GRANT ALL ON SCHEMA public TO joannaanderson;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

