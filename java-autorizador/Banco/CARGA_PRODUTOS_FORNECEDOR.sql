DECLARE
V_CNPJ NUMBER := 1;
BEGIN
    
    FOR X IN (SELECT * FROM TB_PRODUTO_AUX) LOOP
        INSERT INTO TB_PRODUTO
            (COD_PROD, TP_PRODUTO, NOME_PROD, DT_INI, DT_FIM)
        VALUES
            (SQ_PRODUTO.NEXTVAL, 1, X.NOME_PROD, SYSDATE, TO_DATE('30/12/2149','DD/MM/YYYY'));
            
        INSERT INTO TB_FORNECEDOR
            (COD_FORN,
             CNPJ_FORN,
             NOME_FORN,
             COD_EAN,
             NOME_PROD,
             TP_PROD,
             DT_INI,
             DT_FIM)
        VALUES
            (SQ_FORNECEDOR.NEXTVAL,
             V_CNPJ, X.FORNECEDOR, 
             X.EAN_PROD, 
             X.NOME_PROD, 
             1, 
             SYSDATE, 
             TO_DATE('30/12/2149','DD/MM/YYYY'));
             
        V_CNPJ := V_CNPJ + 1;
    END LOOP;
    COMMIT;
END;
