/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Menja
 */
@Provider
public class ExceptionHandling implements ExceptionMapper<Throwable>{

    @Override
    public Response toResponse(Throwable e) {
        return Response.status(500).entity("fejl på serveren").build();
    }
    
}
