# ListaDuplamenteEncadeada
Novo projeto
	function bd_consulta($sql)
	{
		if( $conexao = new mysqli(_SERVIDOR, _USUARIO, _SENHA, _BANCO) );
		{
			if( $dado = $conexao->query($sql) )
			{
				return $dado->fetch_all(MYSQLI_ASSOC);
			}
			
			$conexao->close();
		}
	}
