/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.philb.testorderingsoapclient.commands;

import ie.philb.testorderingsoapclient.Application;
import ie.philb.testorderingsoapclient.ws.OrderingAppService;
import java.util.logging.Logger;

/**
 * @param <ParamType>
 * @param <ReturnType>
 */
public abstract class AbstractCommand<ParamType, ReturnType> {

    protected static final Logger logger = Logger.getLogger(AbstractCommand.class.getSimpleName());
    
    protected Application app() {
        return Application.getApplication();
    }
    
    protected OrderingAppService service() {
        return app().getService();
    }
    
    public abstract ReturnType execute(final ParamType params) throws Exception;
}
