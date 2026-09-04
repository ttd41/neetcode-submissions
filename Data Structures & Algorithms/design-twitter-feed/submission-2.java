class Twitter {

    int currentTs = 0;

    class Node {

        int tid;
        int uid;
        int ts;
        Node prev;
        Node (int tid, int uid, int ts) {
            this.tid = tid;
            this.uid = uid;
            this.ts = ts;
        };

    }

    HashMap<Integer, Node> tweets = new HashMap<>();
    HashMap<Integer, Set<Integer>> follows = new HashMap<>(); 

    public Twitter() {
        currentTs = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Node last = tweets.getOrDefault(userId, null);
        Node newNode = new Node(tweetId, userId, currentTs++);
        newNode.prev = last;
        tweets.put(userId, newNode);

        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.ts - a.ts);

        List<Integer> allUsers = new ArrayList<>(follows.getOrDefault(userId, new HashSet<>()));
        allUsers.add(userId);

        for (Integer id: allUsers) {
            if (!tweets.containsKey(id)) {
                continue;
            }
            Node last = tweets.get(id);
            pq.add(last);
        }

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty() && res.size() < 10) {
            Node node = pq.poll();
            res.add(node.tid);
            if (node.prev != null) {
                pq.add(node.prev);
            }
            
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> fl = follows.getOrDefault(followerId, new HashSet<>());
        fl.add(followeeId);
        follows.put(followerId, fl);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> fl = follows.getOrDefault(followerId, new HashSet<>());
        fl.remove(followeeId);
        follows.put(followerId, fl);
    }
}
