<preConditions onFail="MARK_RAN">
            <not>
                <tableExists tableName="product" />
            </not>
</preConditions>

Cette configuration vérifie si la table product n'existe pas. Si la table product n'existe pas, la condition globale est remplie (true) et le changeSet sera exécuté.
Si la table product existe déjà, la condition globale échoue (false), et en raison de onFail="MARK_RAN", Liquibase marque simplement le changeSet comme ayant été exécuté sans réellement appliquer les modifications.

Cela permet d'éviter d'exécuter le changeSet si la table product existe déjà, tout en gardant une trace que ce changeSet a été "exécuté" pour éviter des tentatives d'exécution futures.