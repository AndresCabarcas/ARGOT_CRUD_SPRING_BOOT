PGDMP     .            
        w            argot    10.10    10.10     �
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �
           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            �
           1262    16415    argot    DATABASE     �   CREATE DATABASE argot WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Colombia.1252' LC_CTYPE = 'Spanish_Colombia.1252';
    DROP DATABASE argot;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �
           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false                        0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    24659    pedido    TABLE     �   CREATE TABLE public.pedido (
    id bigint NOT NULL,
    titulo text NOT NULL,
    diainicio text NOT NULL,
    diafin text NOT NULL,
    descripcion text
);
    DROP TABLE public.pedido;
       public         postgres    false    3            �            1259    24657    pedidos_id_seq    SEQUENCE     w   CREATE SEQUENCE public.pedidos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.pedidos_id_seq;
       public       postgres    false    199    3                       0    0    pedidos_id_seq    SEQUENCE OWNED BY     @   ALTER SEQUENCE public.pedidos_id_seq OWNED BY public.pedido.id;
            public       postgres    false    198            �            1259    16418    producto    TABLE     �   CREATE TABLE public.producto (
    id bigint NOT NULL,
    nombre text,
    cantidad text,
    precio text,
    vendidos text
);
    DROP TABLE public.producto;
       public         postgres    false    3            �            1259    16416    producto_id_seq    SEQUENCE     x   CREATE SEQUENCE public.producto_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.producto_id_seq;
       public       postgres    false    197    3                       0    0    producto_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.producto_id_seq OWNED BY public.producto.id;
            public       postgres    false    196            w
           2604    24662 	   pedido id    DEFAULT     g   ALTER TABLE ONLY public.pedido ALTER COLUMN id SET DEFAULT nextval('public.pedidos_id_seq'::regclass);
 8   ALTER TABLE public.pedido ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    199    198    199            v
           2604    16421    producto id    DEFAULT     j   ALTER TABLE ONLY public.producto ALTER COLUMN id SET DEFAULT nextval('public.producto_id_seq'::regclass);
 :   ALTER TABLE public.producto ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    197    196    197            �
          0    24659    pedido 
   TABLE DATA               L   COPY public.pedido (id, titulo, diainicio, diafin, descripcion) FROM stdin;
    public       postgres    false    199   _       �
          0    16418    producto 
   TABLE DATA               J   COPY public.producto (id, nombre, cantidad, precio, vendidos) FROM stdin;
    public       postgres    false    197   �                  0    0    pedidos_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.pedidos_id_seq', 3, true);
            public       postgres    false    198                       0    0    producto_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.producto_id_seq', 17, true);
            public       postgres    false    196            {
           2606    24667    pedido pedidos_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedidos_pkey PRIMARY KEY (id);
 =   ALTER TABLE ONLY public.pedido DROP CONSTRAINT pedidos_pkey;
       public         postgres    false    199            y
           2606    16426    producto producto_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.producto
    ADD CONSTRAINT producto_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.producto DROP CONSTRAINT producto_pkey;
       public         postgres    false    197            �
   b   x�M�1
�0 �9yE^ mE���p�6J�6�"��:
7��0i�Fm0�>.	q���pe�DA�Vt0�O��KVjր����,Z�zr䦍O��\."��\        �
   �   x�E�A�0E׿�����4�qSn�-Iʐ�	�Tz��m����7�3��҃����Qp�Z�'�̼S���1
!ƪ��[���E���]��m8A��;�yeQ�H�#bc��L�ٞZӃ��ĕ� ��$�ř��1�!e���G���J%ֿ�=c��<B     