PGDMP     ,         	             y            postgres    12.0    12.0 (    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    13318    postgres    DATABASE     �   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE postgres;
                postgres    false            �           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    2948                        2615    115035    dutybank    SCHEMA        CREATE SCHEMA dutybank;
    DROP SCHEMA dutybank;
                postgres    false            �            1259    115195    accounts    TABLE     "  CREATE TABLE dutybank.accounts (
    account_id integer NOT NULL,
    account_type character varying(25) NOT NULL,
    user_id integer NOT NULL,
    balance numeric NOT NULL,
    interest_rate numeric NOT NULL,
    open_date date DEFAULT now() NOT NULL,
    active boolean DEFAULT false
);
    DROP TABLE dutybank.accounts;
       dutybank         heap    postgres    false    8            �            1259    115193    accounts_account_id_seq    SEQUENCE     �   ALTER TABLE dutybank.accounts ALTER COLUMN account_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME dutybank.accounts_account_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            dutybank          postgres    false    8    231            �            1259    115243    employee    TABLE     !  CREATE TABLE dutybank.employee (
    employee_id integer NOT NULL,
    first_name character varying(40) NOT NULL,
    last_name character varying(40) NOT NULL,
    legalid character varying(25) NOT NULL,
    address character varying(255) NOT NULL,
    contact_number bigint NOT NULL,
    gender character varying(6),
    date_birth date NOT NULL,
    nationality character varying(60),
    salary numeric NOT NULL,
    department character varying(60) NOT NULL,
    position_emp character varying(60) NOT NULL,
    login_id integer NOT NULL
);
    DROP TABLE dutybank.employee;
       dutybank         heap    postgres    false    8            �            1259    115241    employee_employee_id_seq    SEQUENCE     �   ALTER TABLE dutybank.employee ALTER COLUMN employee_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME dutybank.employee_employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            dutybank          postgres    false    8    236            �            1259    115161    login    TABLE     �   CREATE TABLE dutybank.login (
    login_id integer NOT NULL,
    email character varying(150) NOT NULL,
    password character varying(150) NOT NULL,
    creation_date date DEFAULT now() NOT NULL,
    user_type character varying(40) NOT NULL
);
    DROP TABLE dutybank.login;
       dutybank         heap    postgres    false    8            �            1259    115159    login_user_id_seq    SEQUENCE     �   ALTER TABLE dutybank.login ALTER COLUMN login_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME dutybank.login_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            dutybank          postgres    false    227    8            �            1259    115227    transactions    TABLE     �   CREATE TABLE dutybank.transactions (
    transaction_id integer NOT NULL,
    account_id integer NOT NULL,
    transaction_type character varying(60) NOT NULL,
    amount numeric NOT NULL,
    transaction_date date DEFAULT now() NOT NULL
);
 "   DROP TABLE dutybank.transactions;
       dutybank         heap    postgres    false    8            �            1259    115225    transactions_transaction_id_seq    SEQUENCE     �   ALTER TABLE dutybank.transactions ALTER COLUMN transaction_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME dutybank.transactions_transaction_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            dutybank          postgres    false    234    8            �            1259    115174    users    TABLE     �  CREATE TABLE dutybank.users (
    user_id integer NOT NULL,
    first_name character varying(40) NOT NULL,
    last_name character varying(40) NOT NULL,
    legalid character varying(25) NOT NULL,
    gender character varying(6),
    contact_number bigint NOT NULL,
    date_birth date NOT NULL,
    address character varying(255) NOT NULL,
    nationality character varying(60),
    salary numeric NOT NULL,
    login_id integer NOT NULL
);
    DROP TABLE dutybank.users;
       dutybank         heap    postgres    false    8            �            1259    115210    users_accounts    TABLE     h   CREATE TABLE dutybank.users_accounts (
    user_id integer NOT NULL,
    account_id integer NOT NULL
);
 $   DROP TABLE dutybank.users_accounts;
       dutybank         heap    postgres    false    8            �            1259    115172    users_user_id_seq    SEQUENCE     �   ALTER TABLE dutybank.users ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME dutybank.users_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            dutybank          postgres    false    229    8            y          0    115195    accounts 
   TABLE DATA           r   COPY dutybank.accounts (account_id, account_type, user_id, balance, interest_rate, open_date, active) FROM stdin;
    dutybank          postgres    false    231            ~          0    115243    employee 
   TABLE DATA           �   COPY dutybank.employee (employee_id, first_name, last_name, legalid, address, contact_number, gender, date_birth, nationality, salary, department, position_emp, login_id) FROM stdin;
    dutybank          postgres    false    236            u          0    115161    login 
   TABLE DATA           V   COPY dutybank.login (login_id, email, password, creation_date, user_type) FROM stdin;
    dutybank          postgres    false    227            |          0    115227    transactions 
   TABLE DATA           p   COPY dutybank.transactions (transaction_id, account_id, transaction_type, amount, transaction_date) FROM stdin;
    dutybank          postgres    false    234            w          0    115174    users 
   TABLE DATA           �   COPY dutybank.users (user_id, first_name, last_name, legalid, gender, contact_number, date_birth, address, nationality, salary, login_id) FROM stdin;
    dutybank          postgres    false    229            z          0    115210    users_accounts 
   TABLE DATA           ?   COPY dutybank.users_accounts (user_id, account_id) FROM stdin;
    dutybank          postgres    false    232            �           0    0    accounts_account_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('dutybank.accounts_account_id_seq', 6, true);
          dutybank          postgres    false    230            �           0    0    employee_employee_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('dutybank.employee_employee_id_seq', 1, true);
          dutybank          postgres    false    235            �           0    0    login_user_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('dutybank.login_user_id_seq', 8, true);
          dutybank          postgres    false    226            �           0    0    transactions_transaction_id_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('dutybank.transactions_transaction_id_seq', 20, true);
          dutybank          postgres    false    233            �           0    0    users_user_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('dutybank.users_user_id_seq', 37, true);
          dutybank          postgres    false    228            �
           2606    115204    accounts accounts_pk 
   CONSTRAINT     \   ALTER TABLE ONLY dutybank.accounts
    ADD CONSTRAINT accounts_pk PRIMARY KEY (account_id);
 @   ALTER TABLE ONLY dutybank.accounts DROP CONSTRAINT accounts_pk;
       dutybank            postgres    false    231            �
           2606    115250    employee employee_pk 
   CONSTRAINT     ]   ALTER TABLE ONLY dutybank.employee
    ADD CONSTRAINT employee_pk PRIMARY KEY (employee_id);
 @   ALTER TABLE ONLY dutybank.employee DROP CONSTRAINT employee_pk;
       dutybank            postgres    false    236            �
           2606    115166    login login_pk 
   CONSTRAINT     T   ALTER TABLE ONLY dutybank.login
    ADD CONSTRAINT login_pk PRIMARY KEY (login_id);
 :   ALTER TABLE ONLY dutybank.login DROP CONSTRAINT login_pk;
       dutybank            postgres    false    227            �
           2606    115235    transactions transactions_pk 
   CONSTRAINT     h   ALTER TABLE ONLY dutybank.transactions
    ADD CONSTRAINT transactions_pk PRIMARY KEY (transaction_id);
 H   ALTER TABLE ONLY dutybank.transactions DROP CONSTRAINT transactions_pk;
       dutybank            postgres    false    234            �
           2606    115214     users_accounts users_accounts_pk 
   CONSTRAINT     q   ALTER TABLE ONLY dutybank.users_accounts
    ADD CONSTRAINT users_accounts_pk PRIMARY KEY (user_id, account_id);
 L   ALTER TABLE ONLY dutybank.users_accounts DROP CONSTRAINT users_accounts_pk;
       dutybank            postgres    false    232    232            �
           2606    115181    users users_pk 
   CONSTRAINT     S   ALTER TABLE ONLY dutybank.users
    ADD CONSTRAINT users_pk PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY dutybank.users DROP CONSTRAINT users_pk;
       dutybank            postgres    false    229            �
           2606    115205    accounts accounts_fk    FK CONSTRAINT     �   ALTER TABLE ONLY dutybank.accounts
    ADD CONSTRAINT accounts_fk FOREIGN KEY (user_id) REFERENCES dutybank.users(user_id) ON DELETE CASCADE;
 @   ALTER TABLE ONLY dutybank.accounts DROP CONSTRAINT accounts_fk;
       dutybank          postgres    false    2791    229    231            �
           2606    115251    employee employee_fk    FK CONSTRAINT     �   ALTER TABLE ONLY dutybank.employee
    ADD CONSTRAINT employee_fk FOREIGN KEY (login_id) REFERENCES dutybank.login(login_id) ON UPDATE CASCADE ON DELETE CASCADE;
 @   ALTER TABLE ONLY dutybank.employee DROP CONSTRAINT employee_fk;
       dutybank          postgres    false    227    236    2789            �
           2606    115236    transactions transactions_fk    FK CONSTRAINT     �   ALTER TABLE ONLY dutybank.transactions
    ADD CONSTRAINT transactions_fk FOREIGN KEY (account_id) REFERENCES dutybank.accounts(account_id) ON UPDATE CASCADE ON DELETE CASCADE;
 H   ALTER TABLE ONLY dutybank.transactions DROP CONSTRAINT transactions_fk;
       dutybank          postgres    false    234    2793    231            �
           2606    115215     users_accounts users_accounts_fk    FK CONSTRAINT     �   ALTER TABLE ONLY dutybank.users_accounts
    ADD CONSTRAINT users_accounts_fk FOREIGN KEY (user_id) REFERENCES dutybank.users(user_id) ON UPDATE CASCADE ON DELETE CASCADE;
 L   ALTER TABLE ONLY dutybank.users_accounts DROP CONSTRAINT users_accounts_fk;
       dutybank          postgres    false    2791    229    232            �
           2606    115220 "   users_accounts users_accounts_fk_1    FK CONSTRAINT     �   ALTER TABLE ONLY dutybank.users_accounts
    ADD CONSTRAINT users_accounts_fk_1 FOREIGN KEY (account_id) REFERENCES dutybank.accounts(account_id) ON UPDATE CASCADE ON DELETE CASCADE;
 N   ALTER TABLE ONLY dutybank.users_accounts DROP CONSTRAINT users_accounts_fk_1;
       dutybank          postgres    false    2793    232    231            �
           2606    115188    users users_fk    FK CONSTRAINT     �   ALTER TABLE ONLY dutybank.users
    ADD CONSTRAINT users_fk FOREIGN KEY (login_id) REFERENCES dutybank.login(login_id) ON DELETE CASCADE;
 :   ALTER TABLE ONLY dutybank.users DROP CONSTRAINT users_fk;
       dutybank          postgres    false    229    2789    227            y   q   x�m�;�0��z|�}x��]� � B�1��@B�o~���n��pWAH�!n����ڮ�y�(p{P$��A�#?��E_���)%g�������@����d�}_�E�1���-�      ~   Z   x��1
�0���.����]�::������=�x?����qC�
st���Mpu�	y��Wb+˘�	l��Yt{�O�����iD�      u   i   x�m�M
� @�s���g�AډB�
���!�`ܽ��#Uz�-��ռ��՛�H.�*�G,�-J�[S:B��06���[�VZ;�����M�g����g� ��QJ      |   �   x���1�0Eg�� (�� w�J���U����P10F����00L��Y�♀,ac�A4N1��d���5�q��W��fPa�D7� :!�l ���f�j�m�ԝH97��<C�e+�	�pwbx��wb�Ir)�k�D��鶒T[�פ;��d.���뤤��1f:;�J      w   �   x�E�?O1���.�b'�%3:� !T��%�p:q�H,|z|�(�[<���	u���8.3 ǔY"�թ���đ) `Nl}���������{2��6�.�ա`�(���I����b����\��$��s٠o`U�>�k��qB�N�֓�7��-z�a�J
���6�s��x��ZƵ�:�z�ȰScB�l���Be�>�������::l�խ��c|�Bإb^�1��)U�      z      x�3�4�2�4�2�4��4����� |�      (    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    13318    postgres    DATABASE     �   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1252' LC_CTYPE = 'English_United States.1252';
    DROP DATABASE postgres;
                postgres    false            �           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    2948                        2615    115035    dutybank    SCHEMA        CREATE SCHEMA dutybank;
    DROP SCHEMA dutybank;
                postgres    false            �            1259    115195    accounts    TABLE     "  CREATE TABLE dutybank.accounts (
    account_id integer NOT NULL,
    account_type character varying(25) NOT NULL,
    user_id integer NOT NULL,
    balance numeric NOT NULL,
    interest_rate numeric NOT NULL,
    open_date date DEFAULT now() NOT NULL,
    active boolean DEFAULT false
);
    DROP TABLE dutybank.accounts;
       dutybank         heap    postgres    false    8            �            1259    115193    accounts_account_id_seq    SEQUENCE     �   ALTER TABLE dutybank.accounts ALTER COLUMN account_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME dutybank.accounts_account_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            dutybank          postgres    false    8    231            �            1259    115243    employee    TABLE     !  CREATE TABLE dutybank.employee (
    employee_id integer NOT NULL,
    first_name character varying(40) NOT NULL,
    last_name character varying(40) NOT NULL,
    legalid character varying(25) NOT NULL,
    address character varying(255) NOT NULL,
    contact_number bigint NOT NULL,
    gender character varying(6),
    date_birth date NOT NULL,
    nationality character varying(60),
    salary numeric NOT NULL,
    department character varying(60) NOT NULL,
    position_emp character varying(60) NOT NULL,
    login_id integer NOT NULL
);
    DROP TABLE dutybank.employee;
       dutybank         heap    postgres    false    8            �            1259    115241    employee_employee_id_seq    SEQUENCE     �   ALTER TABLE dutybank.employee ALTER COLUMN employee_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME dutybank.employee_employee_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            dutybank          postgres    false    8    236            �            1259    115161    login    TABLE     �   CREATE TABLE dutybank.login (
    login_id integer NOT NULL,
    email character varying(150) NOT NULL,
    password character varying(150) NOT NULL,
    creation_date date DEFAULT now() NOT NULL,
    user_type character varying(40) NOT NULL
);
    DROP TABLE dutybank.login;
       dutybank         heap    postgres    false    8            �            1259    115159    login_user_id_seq    SEQUENCE     �   ALTER TABLE dutybank.login ALTER COLUMN login_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME dutybank.login_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            dutybank          postgres    false    227    8            �            1259    115227    transactions    TABLE     �   CREATE TABLE dutybank.transactions (
    transaction_id integer NOT NULL,
    account_id integer NOT NULL,
    transaction_type character varying(60) NOT NULL,
    amount numeric NOT NULL,
    transaction_date date DEFAULT now() NOT NULL
);
 "   DROP TABLE dutybank.transactions;
       dutybank         heap    postgres    false    8            �            1259    115225    transactions_transaction_id_seq    SEQUENCE     �   ALTER TABLE dutybank.transactions ALTER COLUMN transaction_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME dutybank.transactions_transaction_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            dutybank          postgres    false    234    8            �            1259    115174    users    TABLE     �  CREATE TABLE dutybank.users (
    user_id integer NOT NULL,
    first_name character varying(40) NOT NULL,
    last_name character varying(40) NOT NULL,
    legalid character varying(25) NOT NULL,
    gender character varying(6),
    contact_number bigint NOT NULL,
    date_birth date NOT NULL,
    address character varying(255) NOT NULL,
    nationality character varying(60),
    salary numeric NOT NULL,
    login_id integer NOT NULL
);
    DROP TABLE dutybank.users;
       dutybank         heap    postgres    false    8            �            1259    115210    users_accounts    TABLE     h   CREATE TABLE dutybank.users_accounts (
    user_id integer NOT NULL,
    account_id integer NOT NULL
);
 $   DROP TABLE dutybank.users_accounts;
       dutybank         heap    postgres    false    8            �            1259    115172    users_user_id_seq    SEQUENCE     �   ALTER TABLE dutybank.users ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME dutybank.users_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            dutybank          postgres    false    229    8            y          0    115195    accounts 
   TABLE DATA           r   COPY dutybank.accounts (account_id, account_type, user_id, balance, interest_rate, open_date, active) FROM stdin;
    dutybank          postgres    false    231            ~          0    115243    employee 
   TABLE DATA           �   COPY dutybank.employee (employee_id, first_name, last_name, legalid, address, contact_number, gender, date_birth, nationality, salary, department, position_emp, login_id) FROM stdin;
    dutybank          postgres    false    236   {        u          0    115161    login 
   TABLE DATA           V   COPY dutybank.login (login_id, email, password, creation_date, user_type) FROM stdin;
    dutybank          postgres    false    227   d        |          0    115227    transactions 
   TABLE DATA           p   COPY dutybank.transactions (transaction_id, account_id, transaction_type, amount, transaction_date) FROM stdin;
    dutybank          postgres    false    234   s        w          0    115174    users 
   TABLE DATA           �   COPY dutybank.users (user_id, first_name, last_name, legalid, gender, contact_number, date_birth, address, nationality, salary, login_id) FROM stdin;
    dutybank          postgres    false    229   �        z          0    115210    users_accounts 
   TABLE DATA           ?   COPY dutybank.users_accounts (user_id, account_id) FROM stdin;
    dutybank          postgres    false    232           �           0    0    accounts_account_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('dutybank.accounts_account_id_seq', 6, true);
          dutybank          postgres    false    230            �           0    0    employee_employee_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('dutybank.employee_employee_id_seq', 1, true);
          dutybank          postgres    false    235            �           0    0    login_user_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('dutybank.login_user_id_seq', 8, true);
          dutybank          postgres    false    226            �           0    0    transactions_transaction_id_seq    SEQUENCE SET     P   SELECT pg_catalog.setval('dutybank.transactions_transaction_id_seq', 20, true);
          dutybank          postgres    false    233            �           0    0    users_user_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('dutybank.users_user_id_seq', 37, true);
          dutybank          postgres    false    228            �
           2606    115204    accounts accounts_pk 
   CONSTRAINT     \   ALTER TABLE ONLY dutybank.accounts
    ADD CONSTRAINT accounts_pk PRIMARY KEY (account_id);
 @   ALTER TABLE ONLY dutybank.accounts DROP CONSTRAINT accounts_pk;
       dutybank            postgres    false    231            �
           2606    115250    employee employee_pk 
   CONSTRAINT     ]   ALTER TABLE ONLY dutybank.employee
    ADD CONSTRAINT employee_pk PRIMARY KEY (employee_id);
 @   ALTER TABLE ONLY dutybank.employee DROP CONSTRAINT employee_pk;
       dutybank            postgres    false    236            �
           2606    115166    login login_pk 
   CONSTRAINT     T   ALTER TABLE ONLY dutybank.login
    ADD CONSTRAINT login_pk PRIMARY KEY (login_id);
 :   ALTER TABLE ONLY dutybank.login DROP CONSTRAINT login_pk;
       dutybank            postgres    false    227            �
           2606    115235    transactions transactions_pk 
   CONSTRAINT     h   ALTER TABLE ONLY dutybank.transactions
    ADD CONSTRAINT transactions_pk PRIMARY KEY (transaction_id);
 H   ALTER TABLE ONLY dutybank.transactions DROP CONSTRAINT transactions_pk;
       dutybank            postgres    false    234            �
           2606    115214     users_accounts users_accounts_pk 
   CONSTRAINT     q   ALTER TABLE ONLY dutybank.users_accounts
    ADD CONSTRAINT users_accounts_pk PRIMARY KEY (user_id, account_id);
 L   ALTER TABLE ONLY dutybank.users_accounts DROP CONSTRAINT users_accounts_pk;
       dutybank            postgres    false    232    232            �
           2606    115181    users users_pk 
   CONSTRAINT     S   ALTER TABLE ONLY dutybank.users
    ADD CONSTRAINT users_pk PRIMARY KEY (user_id);
 :   ALTER TABLE ONLY dutybank.users DROP CONSTRAINT users_pk;
       dutybank            postgres    false    229            �
           2606    115205    accounts accounts_fk    FK CONSTRAINT     �   ALTER TABLE ONLY dutybank.accounts
    ADD CONSTRAINT accounts_fk FOREIGN KEY (user_id) REFERENCES dutybank.users(user_id) ON DELETE CASCADE;
 @   ALTER TABLE ONLY dutybank.accounts DROP CONSTRAINT accounts_fk;
       dutybank          postgres    false    2791    229    231            �
           2606    115251    employee employee_fk    FK CONSTRAINT     �   ALTER TABLE ONLY dutybank.employee
    ADD CONSTRAINT employee_fk FOREIGN KEY (login_id) REFERENCES dutybank.login(login_id) ON UPDATE CASCADE ON DELETE CASCADE;
 @   ALTER TABLE ONLY dutybank.employee DROP CONSTRAINT employee_fk;
       dutybank          postgres    false    227    236    2789            �
           2606    115236    transactions transactions_fk    FK CONSTRAINT     �   ALTER TABLE ONLY dutybank.transactions
    ADD CONSTRAINT transactions_fk FOREIGN KEY (account_id) REFERENCES dutybank.accounts(account_id) ON UPDATE CASCADE ON DELETE CASCADE;
 H   ALTER TABLE ONLY dutybank.transactions DROP CONSTRAINT transactions_fk;
       dutybank          postgres    false    234    2793    231            �
           2606    115215     users_accounts users_accounts_fk    FK CONSTRAINT     �   ALTER TABLE ONLY dutybank.users_accounts
    ADD CONSTRAINT users_accounts_fk FOREIGN KEY (user_id) REFERENCES dutybank.users(user_id) ON UPDATE CASCADE ON DELETE CASCADE;
 L   ALTER TABLE ONLY dutybank.users_accounts DROP CONSTRAINT users_accounts_fk;
       dutybank          postgres    false    2791    229    232            �
           2606    115220 "   users_accounts users_accounts_fk_1    FK CONSTRAINT     �   ALTER TABLE ONLY dutybank.users_accounts
    ADD CONSTRAINT users_accounts_fk_1 FOREIGN KEY (account_id) REFERENCES dutybank.accounts(account_id) ON UPDATE CASCADE ON DELETE CASCADE;
 N   ALTER TABLE ONLY dutybank.users_accounts DROP CONSTRAINT users_accounts_fk_1;
       dutybank          postgres    false    2793    232    231            �
           2606    115188    users users_fk    FK CONSTRAINT     �   ALTER TABLE ONLY dutybank.users
    ADD CONSTRAINT users_fk FOREIGN KEY (login_id) REFERENCES dutybank.login(login_id) ON DELETE CASCADE;
 :   ALTER TABLE ONLY dutybank.users DROP CONSTRAINT users_fk;
       dutybank          postgres    false    229    2789    227           