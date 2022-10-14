package com.github.startsmercury.simply.no.shading.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.message.EntryMessage;
import org.apache.logging.log4j.message.Message;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.util.MessageSupplier;
import org.apache.logging.log4j.util.Supplier;

import static java.util.Objects.requireNonNull;
import static org.apache.logging.log4j.LogManager.ROOT_LOGGER_NAME;

/**
 * The {@code PrefixedLogger} represents a wrapped logger where messages passed
 * to the delegated logger are prefixed.
 *
 * @since 5.0.0
 */
public class PrefixedLogger implements Logger {
	/**
	 * Returns a named prefix logger.
	 *
	 * @param name   the name of the logger
	 * @param prefix the prefixes to the message
	 * @return a named prefixed logger
	 */
	public static PrefixedLogger named(final String name, final String prefix) {
		return new PrefixedLogger(LogManager.getLogger(name), prefix);
	}

	/**
	 * Returns a prefixed root logger.
	 *
	 * @param prefix the prefixes to the message
	 * @return a prefixed root logger
	 */
	public static PrefixedLogger root(final String prefix) {
		return new PrefixedLogger(prefix);
	}

	/**
	 * Returns a prefix logger.
	 *
	 * @param logger the logger
	 * @param prefix the prefixes to the message
	 * @return a prefixed logger
	 */
	public static PrefixedLogger wrapped(final Logger logger, final String prefix) {
		requireNonNull(logger);

		return new PrefixedLogger(logger, prefix);
	}

	/**
	 * The wrapped or delegated logger.
	 */
	private final Logger delegate;

	/**
	 * The prefixes to the message.
	 */
	private final String prefix;

	/**
	 * Creates a new prefixed logger, wrapping a logger {@code delegate}.
	 *
	 * @param delegate the wrapped or delegated logger
	 * @param prefix   the prefixes to the message
	 */
	public PrefixedLogger(final Logger delegate, final String prefix) {
		this.delegate = delegate == null ? LogManager.getLogger(ROOT_LOGGER_NAME) : delegate;
		this.prefix = prefix != null ? prefix : "";
	}

	/**
	 * Creates a new prefixed logger, wrapping the root logger.
	 *
	 * @param prefix the prefixes to the message
	 */
	public PrefixedLogger(final String prefix) {
		this(null, prefix);
	}

	@Override
	public void catching(Level level, Throwable throwable) {

	}

	@Override
	public void catching(Throwable throwable) {

	}

	@Override
	public void debug(Marker marker, Message message) {

	}

	@Override
	public void debug(Marker marker, Message message, Throwable throwable) {

	}

	@Override
	public void debug(Marker marker, MessageSupplier messageSupplier) {

	}

	@Override
	public void debug(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {

	}

	@Override
	public void debug(Marker marker, CharSequence message) {

	}

	@Override
	public void debug(Marker marker, CharSequence message, Throwable throwable) {

	}

	@Override
	public void debug(Marker marker, Object message) {

	}

	@Override
	public void debug(Marker marker, Object message, Throwable throwable) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void debug(final Marker arg0, final String arg1) {
		this.delegate.debug(arg0, this.prefix + arg1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void debug(final Marker arg0, final String arg1, final Object... arg2) {
		this.delegate.debug(arg0, this.prefix + arg1, arg2);
	}

	@Override
	public void debug(Marker marker, String message, Supplier<?>... paramSuppliers) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void debug(final Marker arg0, final String arg1, final Object arg2) {
		this.delegate.debug(arg0, this.prefix + arg1, arg2);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void debug(final Marker arg0, final String arg1, final Object arg2, final Object arg3) {
		this.delegate.debug(arg0, this.prefix + arg1, arg2, arg3);
	}

	@Override
	public void debug(Marker marker, String message, Object p0, Object p1, Object p2) {

	}

	@Override
	public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {

	}

	@Override
	public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {

	}

	@Override
	public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {

	}

	@Override
	public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {

	}

	@Override
	public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {

	}

	@Override
	public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {

	}

	@Override
	public void debug(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void debug(final Marker arg0, final String arg1, final Throwable arg2) {
		this.delegate.debug(arg0, this.prefix + arg1, arg2);
	}

	@Override
	public void debug(Marker marker, Supplier<?> messageSupplier) {

	}

	@Override
	public void debug(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {

	}

	@Override
	public void debug(Message message) {

	}

	@Override
	public void debug(Message message, Throwable throwable) {

	}

	@Override
	public void debug(MessageSupplier messageSupplier) {

	}

	@Override
	public void debug(MessageSupplier messageSupplier, Throwable throwable) {

	}

	@Override
	public void debug(CharSequence message) {

	}

	@Override
	public void debug(CharSequence message, Throwable throwable) {

	}

	@Override
	public void debug(Object message) {

	}

	@Override
	public void debug(Object message, Throwable throwable) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void debug(final String arg0) {
		this.delegate.debug(this.prefix + arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void debug(final String arg0, final Object... arg1) {
		this.delegate.debug(this.prefix + arg0, arg1);
	}

	@Override
	public void debug(String message, Supplier<?>... paramSuppliers) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void debug(final String arg0, final Object arg1) {
		this.delegate.debug(this.prefix + arg0, arg1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void debug(final String arg0, final Object arg1, final Object arg2) {
		this.delegate.debug(this.prefix + arg0, arg1, arg2);
	}

	@Override
	public void debug(String message, Object p0, Object p1, Object p2) {

	}

	@Override
	public void debug(String message, Object p0, Object p1, Object p2, Object p3) {

	}

	@Override
	public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {

	}

	@Override
	public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {

	}

	@Override
	public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {

	}

	@Override
	public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {

	}

	@Override
	public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {

	}

	@Override
	public void debug(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {

	}

	@Override
	public void entry() {

	}

	@Override
	public void entry(Object... params) {

	}

	@Override
	public void error(Marker marker, Message message) {

	}

	@Override
	public void error(Marker marker, Message message, Throwable throwable) {

	}

	@Override
	public void error(Marker marker, MessageSupplier messageSupplier) {

	}

	@Override
	public void error(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {

	}

	@Override
	public void error(Marker marker, CharSequence message) {

	}

	@Override
	public void error(Marker marker, CharSequence message, Throwable throwable) {

	}

	@Override
	public void error(Marker marker, Object message) {

	}

	@Override
	public void error(Marker marker, Object message, Throwable throwable) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void debug(final String arg0, final Throwable arg1) {
		this.delegate.debug(this.prefix + arg0, arg1);
	}

	@Override
	public void debug(Supplier<?> messageSupplier) {

	}

	@Override
	public void debug(Supplier<?> messageSupplier, Throwable throwable) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void error(final Marker arg0, final String arg1) {
		this.delegate.error(arg0, this.prefix + arg1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void error(final Marker arg0, final String arg1, final Object... arg2) {
		this.delegate.error(arg0, this.prefix + arg1, arg2);
	}

	@Override
	public void error(Marker marker, String message, Supplier<?>... paramSuppliers) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void error(final Marker arg0, final String arg1, final Object arg2) {
		this.delegate.error(arg0, this.prefix + arg1, arg2);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void error(final Marker arg0, final String arg1, final Object arg2, final Object arg3) {
		this.delegate.error(arg0, this.prefix + arg1, arg2, arg3);
	}

	@Override
	public void error(Marker marker, String message, Object p0, Object p1, Object p2) {

	}

	@Override
	public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {

	}

	@Override
	public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {

	}

	@Override
	public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {

	}

	@Override
	public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {

	}

	@Override
	public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {

	}

	@Override
	public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {

	}

	@Override
	public void error(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void error(final Marker arg0, final String arg1, final Throwable arg2) {
		this.delegate.error(arg0, this.prefix + arg1, arg2);
	}

	@Override
	public void error(Marker marker, Supplier<?> messageSupplier) {

	}

	@Override
	public void error(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {

	}

	@Override
	public void error(Message message) {

	}

	@Override
	public void error(Message message, Throwable throwable) {

	}

	@Override
	public void error(MessageSupplier messageSupplier) {

	}

	@Override
	public void error(MessageSupplier messageSupplier, Throwable throwable) {

	}

	@Override
	public void error(CharSequence message) {

	}

	@Override
	public void error(CharSequence message, Throwable throwable) {

	}

	@Override
	public void error(Object message) {

	}

	@Override
	public void error(Object message, Throwable throwable) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void error(final String arg0) {
		this.delegate.error(this.prefix + arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void error(final String arg0, final Object... arg1) {
		this.delegate.error(this.prefix + arg0, arg1);
	}

	@Override
	public void error(String message, Supplier<?>... paramSuppliers) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void error(final String arg0, final Object arg1) {
		this.delegate.error(this.prefix + arg0, arg1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void error(final String arg0, final Object arg1, final Object arg2) {
		this.delegate.error(this.prefix + arg0, arg1, arg2);
	}

	@Override
	public void error(String message, Object p0, Object p1, Object p2) {

	}

	@Override
	public void error(String message, Object p0, Object p1, Object p2, Object p3) {

	}

	@Override
	public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {

	}

	@Override
	public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {

	}

	@Override
	public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {

	}

	@Override
	public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {

	}

	@Override
	public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {

	}

	@Override
	public void error(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {

	}

	@Override
	public void exit() {

	}

	@Override
	public <R> R exit(R result) {
		return null;
	}

	@Override
	public void fatal(Marker marker, Message message) {

	}

	@Override
	public void fatal(Marker marker, Message message, Throwable throwable) {

	}

	@Override
	public void fatal(Marker marker, MessageSupplier messageSupplier) {

	}

	@Override
	public void fatal(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {

	}

	@Override
	public void fatal(Marker marker, CharSequence message) {

	}

	@Override
	public void fatal(Marker marker, CharSequence message, Throwable throwable) {

	}

	@Override
	public void fatal(Marker marker, Object message) {

	}

	@Override
	public void fatal(Marker marker, Object message, Throwable throwable) {

	}

	@Override
	public void fatal(Marker marker, String message) {

	}

	@Override
	public void fatal(Marker marker, String message, Object... params) {

	}

	@Override
	public void fatal(Marker marker, String message, Supplier<?>... paramSuppliers) {

	}

	@Override
	public void fatal(Marker marker, String message, Throwable throwable) {

	}

	@Override
	public void fatal(Marker marker, Supplier<?> messageSupplier) {

	}

	@Override
	public void fatal(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {

	}

	@Override
	public void fatal(Message message) {

	}

	@Override
	public void fatal(Message message, Throwable throwable) {

	}

	@Override
	public void fatal(MessageSupplier messageSupplier) {

	}

	@Override
	public void fatal(MessageSupplier messageSupplier, Throwable throwable) {

	}

	@Override
	public void fatal(CharSequence message) {

	}

	@Override
	public void fatal(CharSequence message, Throwable throwable) {

	}

	@Override
	public void fatal(Object message) {

	}

	@Override
	public void fatal(Object message, Throwable throwable) {

	}

	@Override
	public void fatal(String message) {

	}

	@Override
	public void fatal(String message, Object... params) {

	}

	@Override
	public void fatal(String message, Supplier<?>... paramSuppliers) {

	}

	@Override
	public void fatal(String message, Throwable throwable) {

	}

	@Override
	public void fatal(Supplier<?> messageSupplier) {

	}

	@Override
	public void fatal(Supplier<?> messageSupplier, Throwable throwable) {

	}

	@Override
	public void fatal(Marker marker, String message, Object p0) {

	}

	@Override
	public void fatal(Marker marker, String message, Object p0, Object p1) {

	}

	@Override
	public void fatal(Marker marker, String message, Object p0, Object p1, Object p2) {

	}

	@Override
	public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {

	}

	@Override
	public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {

	}

	@Override
	public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {

	}

	@Override
	public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {

	}

	@Override
	public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {

	}

	@Override
	public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {

	}

	@Override
	public void fatal(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {

	}

	@Override
	public void fatal(String message, Object p0) {

	}

	@Override
	public void fatal(String message, Object p0, Object p1) {

	}

	@Override
	public void fatal(String message, Object p0, Object p1, Object p2) {

	}

	@Override
	public void fatal(String message, Object p0, Object p1, Object p2, Object p3) {

	}

	@Override
	public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {

	}

	@Override
	public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {

	}

	@Override
	public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {

	}

	@Override
	public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {

	}

	@Override
	public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {

	}

	@Override
	public void fatal(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {

	}

	@Override
	public Level getLevel() {
		return null;
	}

	@Override
	public <MF extends MessageFactory> MF getMessageFactory() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void error(final String arg0, final Throwable arg1) {
		this.delegate.error(this.prefix + arg0, arg1);
	}

	@Override
	public void error(Supplier<?> messageSupplier) {

	}

	@Override
	public void error(Supplier<?> messageSupplier, Throwable throwable) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() { return this.delegate.getName(); }

	@Override
	public void info(Marker marker, Message message) {

	}

	@Override
	public void info(Marker marker, Message message, Throwable throwable) {

	}

	@Override
	public void info(Marker marker, MessageSupplier messageSupplier) {

	}

	@Override
	public void info(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {

	}

	@Override
	public void info(Marker marker, CharSequence message) {

	}

	@Override
	public void info(Marker marker, CharSequence message, Throwable throwable) {

	}

	@Override
	public void info(Marker marker, Object message) {

	}

	@Override
	public void info(Marker marker, Object message, Throwable throwable) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void info(final Marker arg0, final String arg1) {
		this.delegate.info(arg0, this.prefix + arg1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void info(final Marker arg0, final String arg1, final Object... arg2) {
		this.delegate.info(arg0, this.prefix + arg1, arg2);
	}

	@Override
	public void info(Marker marker, String message, Supplier<?>... paramSuppliers) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void info(final Marker arg0, final String arg1, final Object arg2) {
		this.delegate.info(arg0, this.prefix + arg1, arg2);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void info(final Marker arg0, final String arg1, final Object arg2, final Object arg3) {
		this.delegate.info(arg0, this.prefix + arg1, arg2, arg3);
	}

	@Override
	public void info(Marker marker, String message, Object p0, Object p1, Object p2) {

	}

	@Override
	public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {

	}

	@Override
	public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {

	}

	@Override
	public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {

	}

	@Override
	public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {

	}

	@Override
	public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {

	}

	@Override
	public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {

	}

	@Override
	public void info(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void info(final Marker arg0, final String arg1, final Throwable arg2) {
		this.delegate.info(arg0, this.prefix + arg1, arg2);
	}

	@Override
	public void info(Marker marker, Supplier<?> messageSupplier) {

	}

	@Override
	public void info(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {

	}

	@Override
	public void info(Message message) {

	}

	@Override
	public void info(Message message, Throwable throwable) {

	}

	@Override
	public void info(MessageSupplier messageSupplier) {

	}

	@Override
	public void info(MessageSupplier messageSupplier, Throwable throwable) {

	}

	@Override
	public void info(CharSequence message) {

	}

	@Override
	public void info(CharSequence message, Throwable throwable) {

	}

	@Override
	public void info(Object message) {

	}

	@Override
	public void info(Object message, Throwable throwable) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void info(final String arg0) {
		this.delegate.info(this.prefix + arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void info(final String arg0, final Object... arg1) {
		this.delegate.info(this.prefix + arg0, arg1);
	}

	@Override
	public void info(String message, Supplier<?>... paramSuppliers) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void info(final String arg0, final Object arg1) {
		this.delegate.info(this.prefix + arg0, arg1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void info(final String arg0, final Object arg1, final Object arg2) {
		this.delegate.info(this.prefix + arg0, arg1, arg2);
	}

	@Override
	public void info(String message, Object p0, Object p1, Object p2) {

	}

	@Override
	public void info(String message, Object p0, Object p1, Object p2, Object p3) {

	}

	@Override
	public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {

	}

	@Override
	public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {

	}

	@Override
	public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {

	}

	@Override
	public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {

	}

	@Override
	public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {

	}

	@Override
	public void info(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void info(final String arg0, final Throwable arg1) {
		this.delegate.info(this.prefix + arg0, arg1);
	}

	@Override
	public void info(Supplier<?> messageSupplier) {

	}

	@Override
	public void info(Supplier<?> messageSupplier, Throwable throwable) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDebugEnabled() { return this.delegate.isDebugEnabled(); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDebugEnabled(final Marker arg0) {
		return this.delegate.isDebugEnabled(arg0);
	}

	@Override
	public boolean isEnabled(Level level) {
		return false;
	}

	@Override
	public boolean isEnabled(Level level, Marker marker) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isErrorEnabled() { return this.delegate.isErrorEnabled(); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isErrorEnabled(final Marker arg0) {
		return this.delegate.isErrorEnabled(arg0);
	}

	@Override
	public boolean isFatalEnabled() {
		return false;
	}

	@Override
	public boolean isFatalEnabled(Marker marker) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isInfoEnabled() { return this.delegate.isInfoEnabled(); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isInfoEnabled(final Marker arg0) {
		return this.delegate.isInfoEnabled(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isTraceEnabled() { return this.delegate.isTraceEnabled(); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isTraceEnabled(final Marker arg0) {
		return this.delegate.isTraceEnabled(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isWarnEnabled() { return this.delegate.isWarnEnabled(); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isWarnEnabled(final Marker arg0) {
		return this.delegate.isWarnEnabled(arg0);
	}

	@Override
	public void log(Level level, Marker marker, Message message) {

	}

	@Override
	public void log(Level level, Marker marker, Message message, Throwable throwable) {

	}

	@Override
	public void log(Level level, Marker marker, MessageSupplier messageSupplier) {

	}

	@Override
	public void log(Level level, Marker marker, MessageSupplier messageSupplier, Throwable throwable) {

	}

	@Override
	public void log(Level level, Marker marker, CharSequence message) {

	}

	@Override
	public void log(Level level, Marker marker, CharSequence message, Throwable throwable) {

	}

	@Override
	public void log(Level level, Marker marker, Object message) {

	}

	@Override
	public void log(Level level, Marker marker, Object message, Throwable throwable) {

	}

	@Override
	public void log(Level level, Marker marker, String message) {

	}

	@Override
	public void log(Level level, Marker marker, String message, Object... params) {

	}

	@Override
	public void log(Level level, Marker marker, String message, Supplier<?>... paramSuppliers) {

	}

	@Override
	public void log(Level level, Marker marker, String message, Throwable throwable) {

	}

	@Override
	public void log(Level level, Marker marker, Supplier<?> messageSupplier) {

	}

	@Override
	public void log(Level level, Marker marker, Supplier<?> messageSupplier, Throwable throwable) {

	}

	@Override
	public void log(Level level, Message message) {

	}

	@Override
	public void log(Level level, Message message, Throwable throwable) {

	}

	@Override
	public void log(Level level, MessageSupplier messageSupplier) {

	}

	@Override
	public void log(Level level, MessageSupplier messageSupplier, Throwable throwable) {

	}

	@Override
	public void log(Level level, CharSequence message) {

	}

	@Override
	public void log(Level level, CharSequence message, Throwable throwable) {

	}

	@Override
	public void log(Level level, Object message) {

	}

	@Override
	public void log(Level level, Object message, Throwable throwable) {

	}

	@Override
	public void log(Level level, String message) {

	}

	@Override
	public void log(Level level, String message, Object... params) {

	}

	@Override
	public void log(Level level, String message, Supplier<?>... paramSuppliers) {

	}

	@Override
	public void log(Level level, String message, Throwable throwable) {

	}

	@Override
	public void log(Level level, Supplier<?> messageSupplier) {

	}

	@Override
	public void log(Level level, Supplier<?> messageSupplier, Throwable throwable) {

	}

	@Override
	public void log(Level level, Marker marker, String message, Object p0) {

	}

	@Override
	public void log(Level level, Marker marker, String message, Object p0, Object p1) {

	}

	@Override
	public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2) {

	}

	@Override
	public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {

	}

	@Override
	public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {

	}

	@Override
	public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {

	}

	@Override
	public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {

	}

	@Override
	public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {

	}

	@Override
	public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {

	}

	@Override
	public void log(Level level, Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {

	}

	@Override
	public void log(Level level, String message, Object p0) {

	}

	@Override
	public void log(Level level, String message, Object p0, Object p1) {

	}

	@Override
	public void log(Level level, String message, Object p0, Object p1, Object p2) {

	}

	@Override
	public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3) {

	}

	@Override
	public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {

	}

	@Override
	public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {

	}

	@Override
	public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {

	}

	@Override
	public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {

	}

	@Override
	public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {

	}

	@Override
	public void log(Level level, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {

	}

	@Override
	public void printf(Level level, Marker marker, String format, Object... params) {

	}

	@Override
	public void printf(Level level, String format, Object... params) {

	}

	@Override
	public <T extends Throwable> T throwing(Level level, T throwable) {
		return null;
	}

	@Override
	public <T extends Throwable> T throwing(T throwable) {
		return null;
	}

	@Override
	public void trace(Marker marker, Message message) {

	}

	@Override
	public void trace(Marker marker, Message message, Throwable throwable) {

	}

	@Override
	public void trace(Marker marker, MessageSupplier messageSupplier) {

	}

	@Override
	public void trace(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {

	}

	@Override
	public void trace(Marker marker, CharSequence message) {

	}

	@Override
	public void trace(Marker marker, CharSequence message, Throwable throwable) {

	}

	@Override
	public void trace(Marker marker, Object message) {

	}

	@Override
	public void trace(Marker marker, Object message, Throwable throwable) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void trace(final Marker arg0, final String arg1) {
		this.delegate.trace(arg0, this.prefix + arg1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void trace(final Marker arg0, final String arg1, final Object... arg2) {
		this.delegate.trace(arg0, this.prefix + arg1, arg2);
	}

	@Override
	public void trace(Marker marker, String message, Supplier<?>... paramSuppliers) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void trace(final Marker arg0, final String arg1, final Object arg2) {
		this.delegate.trace(arg0, this.prefix + arg1, arg2);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void trace(final Marker arg0, final String arg1, final Object arg2, final Object arg3) {
		this.delegate.trace(arg0, this.prefix + arg1, arg2, arg3);
	}

	@Override
	public void trace(Marker marker, String message, Object p0, Object p1, Object p2) {

	}

	@Override
	public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {

	}

	@Override
	public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {

	}

	@Override
	public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {

	}

	@Override
	public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {

	}

	@Override
	public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {

	}

	@Override
	public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {

	}

	@Override
	public void trace(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void trace(final Marker arg0, final String arg1, final Throwable arg2) {
		this.delegate.trace(arg0, this.prefix + arg1, arg2);
	}

	@Override
	public void trace(Marker marker, Supplier<?> messageSupplier) {

	}

	@Override
	public void trace(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {

	}

	@Override
	public void trace(Message message) {

	}

	@Override
	public void trace(Message message, Throwable throwable) {

	}

	@Override
	public void trace(MessageSupplier messageSupplier) {

	}

	@Override
	public void trace(MessageSupplier messageSupplier, Throwable throwable) {

	}

	@Override
	public void trace(CharSequence message) {

	}

	@Override
	public void trace(CharSequence message, Throwable throwable) {

	}

	@Override
	public void trace(Object message) {

	}

	@Override
	public void trace(Object message, Throwable throwable) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void trace(final String arg0) {
		this.delegate.trace(this.prefix + arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void trace(final String arg0, final Object... arg1) {
		this.delegate.trace(this.prefix + arg0, arg1);
	}

	@Override
	public void trace(String message, Supplier<?>... paramSuppliers) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void trace(final String arg0, final Object arg1) {
		this.delegate.trace(this.prefix + arg0, arg1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void trace(final String arg0, final Object arg1, final Object arg2) {
		this.delegate.trace(this.prefix + arg0, arg1, arg2);
	}

	@Override
	public void trace(String message, Object p0, Object p1, Object p2) {

	}

	@Override
	public void trace(String message, Object p0, Object p1, Object p2, Object p3) {

	}

	@Override
	public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {

	}

	@Override
	public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {

	}

	@Override
	public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {

	}

	@Override
	public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {

	}

	@Override
	public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {

	}

	@Override
	public void trace(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {

	}

	@Override
	public EntryMessage traceEntry() {
		return null;
	}

	@Override
	public EntryMessage traceEntry(String format, Object... params) {
		return null;
	}

	@Override
	public EntryMessage traceEntry(Supplier<?>... paramSuppliers) {
		return null;
	}

	@Override
	public EntryMessage traceEntry(String format, Supplier<?>... paramSuppliers) {
		return null;
	}

	@Override
	public EntryMessage traceEntry(Message message) {
		return null;
	}

	@Override
	public void traceExit() {

	}

	@Override
	public <R> R traceExit(R result) {
		return null;
	}

	@Override
	public <R> R traceExit(String format, R result) {
		return null;
	}

	@Override
	public void traceExit(EntryMessage message) {

	}

	@Override
	public <R> R traceExit(EntryMessage message, R result) {
		return null;
	}

	@Override
	public <R> R traceExit(Message message, R result) {
		return null;
	}

	@Override
	public void warn(Marker marker, Message message) {

	}

	@Override
	public void warn(Marker marker, Message message, Throwable throwable) {

	}

	@Override
	public void warn(Marker marker, MessageSupplier messageSupplier) {

	}

	@Override
	public void warn(Marker marker, MessageSupplier messageSupplier, Throwable throwable) {

	}

	@Override
	public void warn(Marker marker, CharSequence message) {

	}

	@Override
	public void warn(Marker marker, CharSequence message, Throwable throwable) {

	}

	@Override
	public void warn(Marker marker, Object message) {

	}

	@Override
	public void warn(Marker marker, Object message, Throwable throwable) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void trace(final String arg0, final Throwable arg1) {
		this.delegate.trace(this.prefix + arg0, arg1);
	}

	@Override
	public void trace(Supplier<?> messageSupplier) {

	}

	@Override
	public void trace(Supplier<?> messageSupplier, Throwable throwable) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void warn(final Marker arg0, final String arg1) {
		this.delegate.warn(arg0, this.prefix + arg1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void warn(final Marker arg0, final String arg1, final Object... arg2) {
		this.delegate.warn(arg0, this.prefix + arg1, arg2);
	}

	@Override
	public void warn(Marker marker, String message, Supplier<?>... paramSuppliers) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void warn(final Marker arg0, final String arg1, final Object arg2) {
		this.delegate.warn(arg0, this.prefix + arg1, arg2);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void warn(final Marker arg0, final String arg1, final Object arg2, final Object arg3) {
		this.delegate.warn(arg0, this.prefix + arg1, arg2, arg3);
	}

	@Override
	public void warn(Marker marker, String message, Object p0, Object p1, Object p2) {

	}

	@Override
	public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3) {

	}

	@Override
	public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4) {

	}

	@Override
	public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {

	}

	@Override
	public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {

	}

	@Override
	public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {

	}

	@Override
	public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {

	}

	@Override
	public void warn(Marker marker, String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void warn(final Marker arg0, final String arg1, final Throwable arg2) {
		this.delegate.warn(arg0, this.prefix + arg1, arg2);
	}

	@Override
	public void warn(Marker marker, Supplier<?> messageSupplier) {

	}

	@Override
	public void warn(Marker marker, Supplier<?> messageSupplier, Throwable throwable) {

	}

	@Override
	public void warn(Message message) {

	}

	@Override
	public void warn(Message message, Throwable throwable) {

	}

	@Override
	public void warn(MessageSupplier messageSupplier) {

	}

	@Override
	public void warn(MessageSupplier messageSupplier, Throwable throwable) {

	}

	@Override
	public void warn(CharSequence message) {

	}

	@Override
	public void warn(CharSequence message, Throwable throwable) {

	}

	@Override
	public void warn(Object message) {

	}

	@Override
	public void warn(Object message, Throwable throwable) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void warn(final String arg0) {
		this.delegate.warn(this.prefix + arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void warn(final String arg0, final Object... arg1) {
		this.delegate.warn(this.prefix + arg0, arg1);
	}

	@Override
	public void warn(String message, Supplier<?>... paramSuppliers) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void warn(final String arg0, final Object arg1) {
		this.delegate.warn(this.prefix + arg0, arg1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void warn(final String arg0, final Object arg1, final Object arg2) {
		this.delegate.warn(this.prefix + arg0, arg1, arg2);
	}

	@Override
	public void warn(String message, Object p0, Object p1, Object p2) {

	}

	@Override
	public void warn(String message, Object p0, Object p1, Object p2, Object p3) {

	}

	@Override
	public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4) {

	}

	@Override
	public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5) {

	}

	@Override
	public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6) {

	}

	@Override
	public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7) {

	}

	@Override
	public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8) {

	}

	@Override
	public void warn(String message, Object p0, Object p1, Object p2, Object p3, Object p4, Object p5, Object p6, Object p7, Object p8, Object p9) {

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void warn(final String arg0, final Throwable arg1) {
		this.delegate.warn(this.prefix + arg0, arg1);
	}

	@Override
	public void warn(Supplier<?> messageSupplier) {

	}

	@Override
	public void warn(Supplier<?> messageSupplier, Throwable throwable) {

	}
}
