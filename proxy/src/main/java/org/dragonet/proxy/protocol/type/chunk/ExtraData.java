/*
 * This file was automatically generated by sel-utils and
 * released under the MIT License.
 * 
 * License: https://github.com/sel-project/sel-utils/blob/master/LICENSE
 * Repository: https://github.com/sel-project/sel-utils
 * Generated from https://github.com/sel-project/sel-utils/blob/master/xml/protocol/bedrock137.xml
 */
package org.dragonet.proxy.protocol.type.chunk;


public class ExtraData extends Stream {

	public int key;
	public short value;

	public ExtraData() {}

	public ExtraData(int key, short value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int length() {
		return Buffer.varuintLength(key) + 2;
	}

	@Override
	public byte[] encode() {
		this._buffer = new byte[this.length()];
		this.writeVaruint(key);
		this.writeLittleEndianShort(value);
		return this.getBuffer();
	}

	@Override
	public void decode(byte[] buffer) {
		this._buffer = buffer;
		key=this.readVaruint();
		value=readLittleEndianShort();
	}

	@Override
	public String toString() {
		return "ExtraData(key: " + this.key + ", value: " + this.value + ")";
	}


}