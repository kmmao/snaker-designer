/* Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.snaker.designer.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.requests.GroupRequest;

import org.snaker.designer.commands.DeleteConnectionCommand;
import org.snaker.designer.model.Transition;

/**
 * 变迁编辑策略
 * @author yuqs
 * @version 1.0
 */
public class TransitionEditPolicy extends ConnectionEditPolicy {
	@Override
	protected Command getDeleteCommand(GroupRequest request) {
		DeleteConnectionCommand command = new DeleteConnectionCommand();
		Transition t = (Transition) getHost().getModel();
		command.setTransition(t);
		command.setSource(t.getSource());
		command.setTarget(t.getTarget());
		return command;
	}

	@Override
	public Command getCommand(Request request) {
		if (REQ_CREATE.equals(request.getType())) {
			return getSplitConnectionCommand(request);
		}
		return super.getCommand(request);
	}

	protected Command getSplitConnectionCommand(Request request) {
		return null;
	}
}
