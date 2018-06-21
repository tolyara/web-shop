-- Table: public.products

-- DROP TABLE public.products;

CREATE TABLE public.products
(
    product_id integer NOT NULL DEFAULT nextval('products_product_id_seq'::regclass),
    product_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    category_id_fk integer NOT NULL,
    manufacturer_name_fk character varying COLLATE pg_catalog."default" NOT NULL,
    price real,
    creation_date date,
    colour character varying(30) COLLATE pg_catalog."default",
    size character varying(30) COLLATE pg_catalog."default",
    amount_in_storage integer,
    CONSTRAINT products_pkey PRIMARY KEY (product_id),
    CONSTRAINT products_category_id_fkey FOREIGN KEY (category_id_fk)
        REFERENCES public.categories (category_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT products_manufacturer_name_fkey FOREIGN KEY (manufacturer_name_fk)
        REFERENCES public.manufacturers (manufacturer_name) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.products
    OWNER to postgres;

INSERT INTO public.products(
	product_id, product_name, category_id_fk, manufacturer_name_fk, price, creation_date, colour, size, amount_in_storage)
	VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);





