CREATE OR REPLACE PACKAGE AUTORIZADOR_REGRAS IS
-----------------------------------------------------------------------------------------
-- RETORNA FARMACIAS PELO COD FARM OU COD_FARM, COD_FILI
-----------------------------------------------------------------------------------------
PROCEDURE RET_FARM(P_COD_FARM  IN  TB_FARMACIA.COD_FARM%TYPE,
                   P_COD_FILI  IN  TB_FARMACIA.COD_FILI%TYPE
                   P_FARMACIA  OUT SYS_REFCURSOR);

-----------------------------------------------------------------------------------------
-- RETORNA PLANO DE SAUDE
-----------------------------------------------------------------------------------------
PROCEDURE RET_PLAS(P_COD_PLAS  IN  TB_PLANO_SAUDE%TYPE,
                   P_PLAS      OUT SYS_REFCURSOR) IS

END AUTORIZADOR_REGRAS;