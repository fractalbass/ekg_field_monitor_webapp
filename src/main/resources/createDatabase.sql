drop table if exists public."sample" cascade;
drop table if exists public."sampleset" cascade;
drop table if exists public."strip" cascade;
drop table if exists public."monitor" cascade;
drop sequence if exists public.monitor_id_seq cascade;
drop sequence if exists public.strip_id_seq cascade;
drop sequence if exists public.sampleset_id_seq cascade;
drop sequence if exists public.sample_id_seq cascade;

CREATE SEQUENCE public.monitor_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.monitor_id_seq
  OWNER TO postgres;

  CREATE SEQUENCE public.strip_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.strip_id_seq
  OWNER TO postgres;

  CREATE SEQUENCE public.sampleset_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.sampleset_id_seq
  OWNER TO postgres;

  CREATE SEQUENCE public.sample_id_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.sample_id_seq
  OWNER TO postgres;

CREATE TABLE monitor
(
    id INTEGER default nextval('monitor_id_seq'::regclass) NOT NULL UNIQUE,
    uuid VARCHAR(40) NOT NULL
);

CREATE TABLE strip
(
    id INTEGER DEFAULT nextval('strip_id_seq'::regclass) NOT NULL UNIQUE,
    uploaded TIMESTAMP DEFAULT now(),
    monitorid INTEGER NOT NULL,
    CONSTRAINT strip_monitor_id_fk FOREIGN KEY (monitorid) REFERENCES monitor (id)
);

CREATE TABLE sampleset
(
    id INTEGER DEFAULT nextval('sampleset_id_seq'::regclass) NOT NULL UNIQUE,
    stripid INTEGER NOT NULL,
    CONSTRAINT strip_set_id_fk FOREIGN KEY (stripid) REFERENCES strip (id)
);
CREATE UNIQUE INDEX sampleset_id_uindex ON sampleset (id);

CREATE TABLE sample
(
    id INTEGER default nextval('sample_id_seq'::regclass) NOT NULL UNIQUE,
    val INTEGER NOT NULL,
    time INTEGER NOT NULL,
    samplesetid INTEGER NOT NULL,
    CONSTRAINT sample_sampleset_id_fk FOREIGN KEY (samplesetid) REFERENCES sampleset (id)
);
