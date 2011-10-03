/*
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.mobicents.servlet.sip.restcomm.xml.twiml;

import java.util.HashSet;
import java.util.Set;

import org.mobicents.servlet.sip.restcomm.xml.Tag;
import org.mobicents.servlet.sip.restcomm.xml.TagVisitor;
import org.mobicents.servlet.sip.restcomm.xml.UnsupportedAttributeException;
import org.mobicents.servlet.sip.restcomm.xml.UnsupportedTagException;
import org.mobicents.servlet.sip.restcomm.xml.VisitorException;

public final class Reject extends TwiMLTag {
  public static final String NAME = "Reject";
  private static final Set<String> ATTRIBUTES;
  static {
    ATTRIBUTES = new HashSet<String>();
    ATTRIBUTES.add(Reason.NAME);
  }
  
  public Reject() {
    super();
    final Reason reason = new Reason();
    reason.setValue(Reason.REJECTED);
    try {
      addAttribute(reason);
    } catch(final UnsupportedAttributeException ignored) {
      // Will never happen.
    }
  }
  
  @Override public void accept(final TagVisitor visitor) throws VisitorException {
    visitor.visit(this);
  }
  
  @Override public void addChild(final Tag child) throws UnsupportedTagException {
	throw new UnsupportedOperationException("The <" + NAME + "> tag may not have any children.");
  }
  
  @Override public boolean canContainAttribute(final String name) {
    return ATTRIBUTES.contains(name);
  }

  @Override public boolean canContainChild(final Tag tag) {
    return false;
  }

  @Override public String getName() {
    return NAME;
  }
  
  @Override public boolean isNoun() {
    return false;
  }
  
  @Override public boolean isVerb() {
    return true;
  }
  
  @Override public void setText(final String text) {
    throw new UnsupportedOperationException("The <" + NAME + "> tag may not have any text.");
  }
}
