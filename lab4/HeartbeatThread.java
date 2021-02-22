class HeartbeatThread implements Runnable {
	private volatile boolean exit = false;
	public void run() {
		for (;;) {
			if (!exit) {
				System.out.print("...");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void stop() {
		exit = true;
	}
}