import "../../src/App.css"

const Formulario = (prop) => {
    return(
        <>
        <form action="" >
            <input type="text" placeholder="Nome" className="form-control"/>
            <input type="text" placeholder="Marca" className="form-control"/>
           
            <div className="form-btn">
                {
                    prop.botao 
                    ?
                    <input type="button" value="Cadastrar" className="btn btn-primary"/>
                    :
                    <div className={prop.botao ? '' : "three-btn"}>
                        <input type="button" value="Alterar" className="btn btn-warning"/>
                        <input type="button" value="Remover" className="btn btn-danger"/>
                        <input type="button" value="Cancelar" className="btn btn-secondary"/>
                    </div>
                }
            </div>
        </form>
        </>
    )
}

export default Formulario;