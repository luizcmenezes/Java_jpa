package br.com.alura;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.com.alura.dto.MensagemErroDto;
import br.com.alura.exception.BusinessExecption;

@Provider
public class BusinessExceptionMapper implements ExceptionMapper<BusinessExecption> {

    @Override
    public Response toResponse(BusinessExecption e) {
        return Response.status(Response.Status.BAD_REQUEST).entity(MensagemErroDto.build(e.getMensagens())).build();
    }

}
